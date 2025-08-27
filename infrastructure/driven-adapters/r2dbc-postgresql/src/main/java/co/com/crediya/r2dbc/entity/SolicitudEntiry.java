package co.com.crediya.r2dbc.entity;

import co.com.crediya.model.estado.Estado;
import co.com.crediya.model.tipoPrestamo.TipoPrestamo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("solicitud")
public class SolicitudEntiry {
    @Id
    @Column("id_solicitud")
    private Long id_solicitud;
    private Float monto;
    private Integer plazo;
    private String email;
    private Estado estado;
    private TipoPrestamo tipoPrestamo;
}
