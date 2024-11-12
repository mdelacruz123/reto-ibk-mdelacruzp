package com.example.microservicio.cliente.repository;

import com.example.microservicio.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCodigoUnicoAndActivoTrue(String codigoUnico);
}
