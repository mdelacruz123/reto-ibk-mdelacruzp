package com.example.microservicio.producto.repository;

import com.example.microservicio.producto.model.ProductoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductoClienteRepository extends JpaRepository<ProductoCliente, Long> {

    @Query("SELECT pc FROM ProductoCliente pc JOIN pc.productoFinanciero pf WHERE pc.clienteId = :clienteId AND pf.activo = true")
    List<ProductoCliente> findActiveProductsByClienteId(@Param("clienteId") Long clienteId);
}
