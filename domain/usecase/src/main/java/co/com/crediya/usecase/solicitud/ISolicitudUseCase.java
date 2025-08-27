package co.com.crediya.usecase.solicitud;

import co.com.crediya.model.solicitud.Solicitud;
import reactor.core.publisher.Mono;

public interface ISolicitudUseCase {
     Mono<Solicitud> createSolicitud(Solicitud solicitud);
}
