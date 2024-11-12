package com.example.microservicio.producto.controller;

import com.example.microservicio.producto.dto.ProductoFinancieroDto;
import com.example.microservicio.producto.service.ProductoClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductoClienteControllerTest {

    @Mock
    private ProductoClienteService productoClienteService;

    @InjectMocks
    private ProductoClienteController productoClienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getActiveProductsByClienteId_ReturnsProducts() {
        Long clienteId = 1L;
        ProductoFinancieroDto producto = new ProductoFinancieroDto(1L, "Cuenta de Ahorro", "Cuenta de Ahorro", 1000.0);
        List<ProductoFinancieroDto> expectedProducts = Collections.singletonList(producto);

        when(productoClienteService.getActiveProductsByClienteId(clienteId)).thenReturn(expectedProducts);

        ResponseEntity<List<ProductoFinancieroDto>> response = productoClienteController.getActiveProductsByClienteId(clienteId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Cuenta de Ahorro", response.getBody().get(0).getNombre());
    }
}
