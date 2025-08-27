package co.com.crediya.usecase.solicitud.impl;

import co.com.crediya.model.solicitud.Solicitud;
import co.com.crediya.model.solicitud.gateways.SolicitudRepository;
import co.com.crediya.usecase.solicitud.ISolicitudUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SolicitudUseCase implements ISolicitudUseCase {
    private final SolicitudRepository repository;

    @Override
    public Mono<Solicitud> createSolicitud(Solicitud solicitud) {
        return repository.saveSolicitud(solicitud);
    }
}
