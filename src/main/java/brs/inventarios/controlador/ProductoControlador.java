package brs.inventarios.controlador;
/// clase controlador tipo RESR
import brs.inventarios.excepcion.RecursoNoEncontradoExcepcion;
import brs.inventarios.modelo.Producto;
import brs.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://Localhost:8080/inventario-app
@RequestMapping("inventario-app")
//peticiones del frontend de angular///
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;
        //http://localhost:8080/inventario-app/productos

    @GetMapping("/productos")
///controlador para obtner todos los productos
     public List<Producto> obtenerProductos(){
          List<Producto> productos = this.productoServicio.ListarProductos();
          logger.info("Productos obtenidos:");
          productos.forEach((producto -> logger.info(producto.toString())));

          return productos;
     }
     @PostMapping("/productos")
     ///controlador para crear o agregar productos a la DB//
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a Agregar: "+ producto);
        return this.productoServicio.guardarProducto(producto);

     }


     @GetMapping("/productos/{id}")
     //trae los productos por ID///
        public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if (producto != null)
        return ResponseEntity.ok(producto);
        else
          throw  new RecursoNoEncontradoExcepcion("No se encontro  el id:" + id );
    }
@PutMapping("/productos/{id}")
//controlador para editar o actualizar los productos//
public ResponseEntity<Producto> actualizarProducto(
      @PathVariable int id,
      @RequestBody Producto productoRecibido){
Producto producto =this.productoServicio.buscarProductoPorId(id);
    if (producto == null)
        throw  new RecursoNoEncontradoExcepcion("No se encontro  el id:" + id );    
producto.setDescripcion(productoRecibido.getDescripcion());
producto.setPrecio(productoRecibido.getPrecio());
producto.setExistencia(productoRecibido.getExistencia());
this.productoServicio.guardarProducto(producto);
    return ResponseEntity.ok(producto);
}
@DeleteMapping("/productos/{id}")
///metodo par aeliminar el producto ///
    public ResponseEntity <Map<String, Boolean>> eliminarProducto(
        @PathVariable int id ){
        Producto producto=  productoServicio.buscarProductoPorId(id);
        if (producto == null)
            throw  new RecursoNoEncontradoExcepcion("No se encontro  el id:" + id );
        this.productoServicio.eliminarProductoPorId(producto.getIdProducto());
        Map< String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

}




}
