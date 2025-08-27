package co.com.crediya.model.solicitud;
import co.com.crediya.model.estado.Estado;
import co.com.crediya.model.tipoPrestamo.TipoPrestamo;
import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Solicitud {
    private Long id_solicitud;
    private Double monto;
    private Integer plazo;
    private String email;
    private Long id_estado;
    private Long id_tipo_prestamo;
}
