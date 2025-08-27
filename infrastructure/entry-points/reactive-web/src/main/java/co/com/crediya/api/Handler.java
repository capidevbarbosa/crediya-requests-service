package co.com.crediya.api;

import co.com.crediya.api.config.ValidatorConfig;
import co.com.crediya.api.dto.SolicitudCreateDto;
import co.com.crediya.api.mapper.SolicitudDTOMapper;
import co.com.crediya.model.solicitud.Solicitud;
import co.com.crediya.usecase.solicitud.impl.SolicitudUseCase;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Handler {
    private final SolicitudUseCase solicitudUseCase;
    private final SolicitudDTOMapper solicitudDTOMapper;
    private final Validator validator;

    public Mono<ServerResponse> listenPOSTCrearSolicitud(ServerRequest serverRequest) {
             return serverRequest.bodyToMono(SolicitudCreateDto.class).log()
                     .flatMap(dto -> {
                         // 1. Validar el DTO
                         Set<ConstraintViolation<SolicitudCreateDto>> violations = validator.validate(dto);
                         if (!violations.isEmpty()) {
                             // 2. Transformar errores en un JSON amigable
                             Map<String, String> errors = violations.stream()
                                     .collect(Collectors.toMap(
                                             v -> v.getPropertyPath().toString(),
                                             ConstraintViolation::getMessage
                                     ));

                             return ServerResponse.badRequest()
                                     .bodyValue(Map.of(
                                             "status", HttpStatus.BAD_REQUEST.value(),
                                             "errors", errors
                                     ));
                         }

                         Solicitud solicitud = solicitudDTOMapper.toModel(dto);

                         return solicitudUseCase.createSolicitud(solicitud)
                                 .flatMap(saved -> ServerResponse.status(HttpStatus.CREATED)
                                         .bodyValue("Solicitud creada con exito, \nNo. solicitud: "+ saved.getId_solicitud()))
                                         .onErrorResume(e-> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                                 .bodyValue("Error al crear la nueva solicitud\n " + e.getMessage()));});
}
}
