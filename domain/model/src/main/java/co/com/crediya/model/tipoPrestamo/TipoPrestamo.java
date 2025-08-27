package co.com.crediya.model.tipoPrestamo;


import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TipoPrestamo {
    private Long id_tipo_prestamo;
    private Float monto_minimo;
    private Float monto_maximo;
    private Float tasa_intereses;
    private String validacion_automatica;
}
