package com.example.microservicio.producto.service;

import com.example.microservicio.producto.dto.ProductoFinancieroDto;
import com.example.microservicio.producto.mapper.ProductoClienteMapper;
import com.example.microservicio.producto.repository.ProductoClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoClienteServiceImpl implements ProductoClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoClienteServiceImpl.class);
    private final ProductoClienteRepository productoClienteRepository;
    private final ProductoClienteMapper productoClienteMapper;

    public ProductoClienteServiceImpl(ProductoClienteRepository productoClienteRepository, ProductoClienteMapper productoClienteMapper) {
        this.productoClienteRepository = productoClienteRepository;
        this.productoClienteMapper = productoClienteMapper;
    }

    @Override
    public List<ProductoFinancieroDto> getActiveProductsByClienteId(Long clienteId) {
        String trackingId = MDC.get("trackingId");
        logger.info("tracking ID: {} , obteniendo productos financieros del cliente ID: {} ", trackingId, clienteId);
        List<ProductoFinancieroDto> productos = productoClienteMapper.toDtoList(productoClienteRepository.findActiveProductsByClienteId(clienteId));
        logger.info("tracking ID: {} - Encotrados {} productos para el cliente ID: {}", trackingId, clienteId, productos.size());
        return productos;
    }
}
