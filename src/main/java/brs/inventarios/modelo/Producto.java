package brs.inventarios.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


//creacion de forma automatica en la base de datos con @Entity por hibernatte//
@Entity
/// simplifica el codigo de los getters y setters
@Data
//contructores
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Producto {
    ///llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   /// atributos de la base de datos///
    Integer idProducto;
    String  descripcion;
    Double precio;
    Integer existencia;

}
