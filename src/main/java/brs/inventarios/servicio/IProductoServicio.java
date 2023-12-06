package brs.inventarios.servicio;

import brs.inventarios.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> ListarProductos();
    public Producto buscarProductoPorId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProductoPorId(Integer idProducto);
}
