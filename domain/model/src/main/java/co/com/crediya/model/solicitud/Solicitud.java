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
    private Float monto;
    private Integer plazo;
    private String email;
    private Estado estado;
    private TipoPrestamo tipoPrestamo;
}
