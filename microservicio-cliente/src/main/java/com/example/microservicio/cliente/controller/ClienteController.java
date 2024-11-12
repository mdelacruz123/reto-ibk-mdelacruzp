package com.example.microservicio.cliente.controller;

import com.example.microservicio.cliente.dto.ClienteDto;
import com.example.microservicio.cliente.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = "Operaciones relacionadas con clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(summary = "Obtener cliente por código único", description = "Devuelve la información de un cliente")
    @GetMapping("/{codigoUnico}")
    public ClienteDto obtenerClientePorCodigoUnico(@Parameter(description = "Código único del cliente encriptado") @PathVariable String codigoUnico) {
        return clienteService.obtenerClientePorCodigoUnico(codigoUnico);
    }
}
