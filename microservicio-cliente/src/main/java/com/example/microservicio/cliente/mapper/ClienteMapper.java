package com.example.microservicio.cliente.mapper;

import com.example.microservicio.cliente.model.Cliente;
import com.example.microservicio.cliente.dto.ClienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombres", target = "nombres")
    @Mapping(source = "apellidoPaterno", target = "apellidoPaterno")
    @Mapping(source = "apellidoMaterno", target = "apellidoMaterno")
    @Mapping(source = "tipoDocumento", target = "tipoDocumento")
    @Mapping(source = "numeroDocumento", target = "numeroDocumento")
    ClienteDto clienteToClienteDto(Cliente cliente);
}
