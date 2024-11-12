package com.example.microservicio.cliente.service;

import com.example.microservicio.cliente.dto.ClienteDto;
import com.example.microservicio.cliente.exception.ClienteNoEncontradoException;
import com.example.microservicio.cliente.model.Cliente;
import com.example.microservicio.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerClientePorCodigoUnico_clienteExistente_retornaClienteDto() {
        Cliente cliente = new Cliente();
        cliente.setCodigoUnico("12345");
        cliente.setNombres("Juan");
        cliente.setApellidoPaterno("Pérez");
        cliente.setApellidoMaterno("Gómez");
        cliente.setTipoDocumento("DNI");
        cliente.setNumeroDocumento("87654321");

        when(clienteRepository.findByCodigoUnicoAndActivoTrue("12345")).thenReturn(Optional.of(cliente));

        ClienteDto clienteDto = clienteService.obtenerClientePorCodigoUnico("12345");

        assertEquals("Juan", clienteDto.getNombres());
        assertEquals("Pérez", clienteDto.getApellidoPaterno());
        assertEquals("Gómez", clienteDto.getApellidoMaterno());
        assertEquals("DNI", clienteDto.getTipoDocumento());
        assertEquals("87654321", clienteDto.getNumeroDocumento());
    }

    @Test
    void obtenerClientePorCodigoUnico_clienteNoExistente_lanzaClienteNoEncontradoException() {
        when(clienteRepository.findByCodigoUnicoAndActivoTrue("99999")).thenReturn(Optional.empty());

        assertThrows(ClienteNoEncontradoException.class, () -> clienteService.obtenerClientePorCodigoUnico("99999"));
    }
}