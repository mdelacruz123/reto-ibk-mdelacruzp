package com.example.microservicio.cliente.service;

import com.example.microservicio.cliente.dto.ClienteDto;

public interface ClienteService {
    ClienteDto obtenerClientePorCodigoUnico(String codigoUnico);
}
