package com.example.microservicio.cliente.controller;

import com.example.microservicio.cliente.service.ClienteService;
import com.example.microservicio.cliente.dto.ClienteDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    void obtenerCliente_debeRetornarClienteDto() throws Exception {
        String codigoUnico = "12345";
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombres("Juan");
        clienteDto.setApellidoPaterno("Pérez");
        clienteDto.setApellidoMaterno("Gómez");
        clienteDto.setTipoDocumento("DNI");
        clienteDto.setNumeroDocumento("87654321");

        when(clienteService.obtenerClientePorCodigoUnico(codigoUnico)).thenReturn(clienteDto);

        mockMvc.perform(get("/api/v1/clientes/{codigoUnico}", codigoUnico)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombres").value("Juan"))
                .andExpect(jsonPath("$.apellidoPaterno").value("Pérez"))
                .andExpect(jsonPath("$.apellidoMaterno").value("Gómez"))
                .andExpect(jsonPath("$.tipoDocumento").value("DNI"))
                .andExpect(jsonPath("$.numeroDocumento").value("87654321"));
    }
}