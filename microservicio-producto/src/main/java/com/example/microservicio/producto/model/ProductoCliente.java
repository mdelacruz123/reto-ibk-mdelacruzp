package com.example.microservicio.producto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto_cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoFinanciero productoFinanciero;

    @Column(name = "saldo", nullable = false)
    private Double saldo;
}
