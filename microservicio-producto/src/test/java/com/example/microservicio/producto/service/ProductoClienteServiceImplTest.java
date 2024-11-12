package com.example.microservicio.producto.service;

import com.example.microservicio.producto.dto.ProductoFinancieroDto;
import com.example.microservicio.producto.mapper.ProductoClienteMapper;
import com.example.microservicio.producto.model.ProductoCliente;
import com.example.microservicio.producto.model.ProductoFinanciero;
import com.example.microservicio.producto.repository.ProductoClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductoClienteServiceImplTest {

    @Mock
    private ProductoClienteRepository productoClienteRepository;

    @Mock
    private ProductoClienteMapper productoClienteMapper;

    @InjectMocks
    private ProductoClienteServiceImpl productoClienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getActiveProductsByClienteId_ReturnsSingleProduct() {
        Long clienteId = 1L;

        ProductoFinanciero producto = new ProductoFinanciero(1L, "Cuenta de Ahorro", "Cuenta de Ahorro", true);
        ProductoCliente productoCliente = new ProductoCliente(1L, clienteId, producto, 1000.0);
        ProductoFinancieroDto productoDto = new ProductoFinancieroDto(1L, "Cuenta de Ahorro", "Cuenta de Ahorro", 1000.0);

        when(productoClienteRepository.findActiveProductsByClienteId(clienteId)).thenReturn(List.of(productoCliente));
        when(productoClienteMapper.toDtoList(List.of(productoCliente))).thenReturn(List.of(productoDto));

        List<ProductoFinancieroDto> result = productoClienteService.getActiveProductsByClienteId(clienteId);

        assertEquals(1, result.size());
        assertEquals("Cuenta de Ahorro", result.get(0).getNombre());
    }
}