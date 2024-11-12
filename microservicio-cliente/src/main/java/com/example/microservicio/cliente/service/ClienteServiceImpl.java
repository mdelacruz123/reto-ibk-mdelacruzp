package com.example.microservicio.cliente.service;

import com.example.microservicio.cliente.dto.ClienteDto;
import com.example.microservicio.cliente.exception.ClienteNoEncontradoException;
import com.example.microservicio.cliente.mapper.ClienteMapper;
import com.example.microservicio.cliente.model.Cliente;
import com.example.microservicio.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDto obtenerClientePorCodigoUnico(String codigoUnico) {
        String trackingId = MDC.get("trackingId");
        logger.info("Tracking ID: {} - Obteniendo cliente con codigoUnico: {}", trackingId, codigoUnico);
        Cliente cliente = clienteRepository.findByCodigoUnicoAndActivoTrue(codigoUnico)
                .orElseThrow(() -> {
                    logger.warn("Tracking ID: {} - Cliente con codigoUnico {} no encontrado", trackingId, codigoUnico);
                    return new ClienteNoEncontradoException("Cliente no encontrado");
                });

        ClienteDto clienteDto = ClienteMapper.INSTANCE.clienteToClienteDto(cliente);
        logger.debug("Tracking ID: {} - ClienteDto mapeado: {}", trackingId, clienteDto);
        return clienteDto;
    }
}
