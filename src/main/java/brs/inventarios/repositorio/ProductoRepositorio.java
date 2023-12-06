package brs.inventarios.repositorio;

import brs.inventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
////capa de acceso a datos
///clase hija
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
