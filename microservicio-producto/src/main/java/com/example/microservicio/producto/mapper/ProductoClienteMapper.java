package com.example.microservicio.producto.mapper;

import com.example.microservicio.producto.dto.ProductoFinancieroDto;
import com.example.microservicio.producto.model.ProductoCliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoClienteMapper {

    @Mapping(source = "productoFinanciero.id", target = "id")
    @Mapping(source = "productoFinanciero.tipoProducto", target = "tipoProducto")
    @Mapping(source = "productoFinanciero.nombre", target = "nombre")
    @Mapping(source = "saldo", target = "saldo")
    ProductoFinancieroDto toDto(ProductoCliente productoCliente);

    List<ProductoFinancieroDto> toDtoList(List<ProductoCliente> productoClienteList);
}
