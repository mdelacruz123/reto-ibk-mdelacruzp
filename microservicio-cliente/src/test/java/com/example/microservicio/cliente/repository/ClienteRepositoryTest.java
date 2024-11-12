package com.example.microservicio.cliente.repository;

import com.example.microservicio.cliente.model.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente(null, "123ABC", "Juan", "Perez", "Lopez", "DNI", "12345678", true);
        clienteRepository.save(cliente);
    }

    @Test
    void testFindByCodigoUnico() {
        Optional<Cliente> resultado = clienteRepository.findByCodigoUnicoAndActivoTrue("123ABC");

        assertTrue(resultado.isPresent());
        assertEquals("Juan", resultado.get().getNombres());
        assertEquals("Perez", resultado.get().getApellidoPaterno());
        assertEquals("Lopez", resultado.get().getApellidoMaterno());
        assertEquals("DNI", resultado.get().getTipoDocumento());
        assertEquals("12345678", resultado.get().getNumeroDocumento());
    }

}