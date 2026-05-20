package pe.edu.upeu.sysventas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    private Long idProducto;
    @NotBlank(message = "El campo nombre es obligatorio")
    private String nombre;

    @NotNull(message="Este campo no puede ser nulo")
    @Positive(message = "El campo precio unitario debe ser positivo")
    private Double pu;
    private Double puold;
    private Double utilidad;

    @PositiveOrZero(message = "El campo stock debe ser positivo  o cero")
    private Double stock;

    @PositiveOrZero(message = "El campo stockold debe ser positivo o cero")
    private Double stockold;

    @NotNull(message="La categoría no puede ser nulo")
    private Categoria idCategoria;

    @NotNull(message="Marca no puede ser nulo")
    private Marca idMarca;

    @NotNull(message="Unidad de medida no puede ser nulo")
    private UnidadMedida idUnidad;
}