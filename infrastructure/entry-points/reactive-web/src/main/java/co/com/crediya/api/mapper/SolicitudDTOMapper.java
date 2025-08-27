package co.com.crediya.api.mapper;

import co.com.crediya.api.dto.SolicitudCreateDto;
import co.com.crediya.api.dto.SolicitudDto;
import co.com.crediya.model.solicitud.Solicitud;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitudDTOMapper {
    SolicitudDto toResponse(Solicitud usuario);
    Solicitud toModel(SolicitudCreateDto createUsuarioDto);
}
