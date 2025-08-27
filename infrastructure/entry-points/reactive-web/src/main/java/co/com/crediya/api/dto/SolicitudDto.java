package co.com.crediya.api.dto;

import co.com.crediya.model.estado.Estado;
import co.com.crediya.model.tipoPrestamo.TipoPrestamo;

public record SolicitudDto(
        Long id_solicitud,
        Double monto,
        Integer plazo,
        String email,
        Long id_estado,
        Long  id_tipo_prestamo
) {
}
