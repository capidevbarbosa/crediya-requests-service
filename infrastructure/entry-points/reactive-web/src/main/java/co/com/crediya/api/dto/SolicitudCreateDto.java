package co.com.crediya.api.dto;

import co.com.crediya.model.estado.Estado;
import co.com.crediya.model.tipoPrestamo.TipoPrestamo;
import jakarta.validation.constraints.*;

public record SolicitudCreateDto(
        @NotNull(message = "El monto  es obligatorio")
        Double monto,
        @NotNull(message = "El plazo es obligatorio")
        Integer plazo,
        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El email debe estar enun formato valido")
        String email,
        @NotNull(message = "El estado es obligatorio")
        Long id_estado,
        @NotNull(message = "Se debe proporcionar un tipo de prestamo")
        Long id_tipo_prestamo
) {

}
