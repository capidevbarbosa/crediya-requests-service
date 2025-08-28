package co.com.crediya.api.config;

import co.com.crediya.api.Handler;
import co.com.crediya.api.dto.SolicitudCreateDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Crediya-requests-service API",
                version = "1.0",
                description = "Documentación de la API de solicitudes de crédito"
        )
)
public class SwaggerConfig {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/v1/solicitud",
                    produces = {"application/json"},
                    method = RequestMethod.POST,
                    beanClass = Handler.class,
                    beanMethod = "listenPOSTCrearSolicitud",
                    operation = @Operation(
                            operationId = "crearSolicitud",
                            summary = "Crea una nueva solicitud de crédito",
                            tags = {"Solicitud"},
                            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                    required = true,
                                    description = "Datos de la nueva solicitud",
                                    content = @Content(schema = @Schema(implementation = SolicitudCreateDto.class))
                            ),
                            responses = {
                                    @ApiResponse(
                                            responseCode = "201",
                                            description = "Solicitud creada exitosamente",
                                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                                    schema = @Schema(type = "string", example = "Solicitud creada con exito, \n" +
                                                            "No. solicitud: 123"))
                                    ), @ApiResponse(
                                    responseCode = "400",
                                    description = "Error de validación",
                                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(type = "string", example = "{\n" +
                                                    "  \"errors\": {\n" +
                                                    "    \"apellido\": \"El apellido es obligatorio\"\n" +
                                                    "  },\n" +
                                                    "  \"status\": 400\n" +
                                                    "}"))
                            ),
                                    @ApiResponse(responseCode = "500", description = "Error interno")
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> swaggerRouter(Handler handler) {
        return RouterFunctions.route()
                .POST("/api/v1/solicitud", handler::listenPOSTCrearSolicitud)
                .build();
    }
}

