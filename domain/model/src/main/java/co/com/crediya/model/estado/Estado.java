package co.com.crediya.model.estado;
import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Estado {

    private Long id_estado;
    private String nombre;
    private String descripcion;
}
