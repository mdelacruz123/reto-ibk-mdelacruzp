package com.example.microservicio.producto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoFinancieroDto {
    private Long id;
    private String tipoProducto;
    private String nombre;
    private Double saldo;
}
