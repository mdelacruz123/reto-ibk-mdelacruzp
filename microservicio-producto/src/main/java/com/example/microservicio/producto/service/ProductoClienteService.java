package com.example.microservicio.producto.service;

import com.example.microservicio.producto.dto.ProductoFinancieroDto;

import java.util.List;

public interface ProductoClienteService {
    List<ProductoFinancieroDto> getActiveProductsByClienteId(Long clienteId);
}
