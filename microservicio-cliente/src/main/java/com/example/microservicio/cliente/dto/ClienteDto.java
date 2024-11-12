package com.example.microservicio.cliente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Detalles de un cliente")
public class ClienteDto {

    @Schema(description = "identificador Interno del cliente", example = "Juan")
    private Long id;

    @Schema(description = "Codigo Unico del cliente", example = "ABC123")
    private String nombres;

    @Schema(description = "Apellido paterno del cliente", example = "Pérez")
    private String apellidoPaterno;

    @Schema(description = "Apellido materno del cliente", example = "González")
    private String apellidoMaterno;

    @Schema(description = "Tipo de documento", example = "DNI")
    private String tipoDocumento;

    @Schema(description = "Número de documento", example = "12345678")
    private String numeroDocumento;
}
