package com.example.microservicio.producto.controller;

import com.example.microservicio.producto.dto.ProductoFinancieroDto;
import com.example.microservicio.producto.service.ProductoClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoClienteController {

    private final ProductoClienteService productoClienteService;

    public ProductoClienteController(ProductoClienteService productoClienteService) {
        this.productoClienteService = productoClienteService;
    }

    @Operation(summary = "Obtener productos financieros activos por cliente ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exitoso"),
            @ApiResponse(responseCode = "404", description = "Productos no encontrados"),
    })
    @GetMapping("/{clienteId}")
    public ResponseEntity<List<ProductoFinancieroDto>> getActiveProductsByClienteId(
            @PathVariable Long clienteId) {
        List<ProductoFinancieroDto> products = productoClienteService.getActiveProductsByClienteId(clienteId);
        return ResponseEntity.ok(products);
    }
}
