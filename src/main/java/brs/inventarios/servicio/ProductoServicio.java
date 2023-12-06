package brs.inventarios.servicio;
///creala conexion con la entidad y modelo //
import brs.inventarios.modelo.Producto;
import brs.inventarios.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductoServicio implements IProductoServicio{
///metodos de implementacion//
    ///inyectar objeto ProductoRepositorio
   @Autowired
   private ProductoRepositorio productoRepositorio;
    @Override
    public List<Producto> ListarProductos() {
      return this.productoRepositorio.findAll();

    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto =
                this.productoRepositorio.findById( idProducto).orElse(null);
        return producto;
    }
    @Override
    public Producto guardarProducto(Producto producto) {

       return this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);

    }
}
