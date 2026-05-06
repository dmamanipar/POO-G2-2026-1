package pe.edu.upeu.model;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;
import lombok.*;

@MappedEntity(value = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliente {
    @Id
    @MappedProperty(type = DataType.STRING, value = "dni")
    private String idDni;
    @MappedProperty(type = DataType.STRING, value = "nombre")
    private String nombre;
    @MappedProperty(type = DataType.STRING, value = "telefono")
    private String telefono;
    @MappedProperty(type = DataType.STRING, value = "email")
    private String email;
}
