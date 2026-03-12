package com.practica.servicio.controller;

import com.practica.servicio.product.Objeto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import servicio.ServiceProducto;

import java.util.List;

@RestController
public class ControllerProducto {
    ServiceProducto serviceProducto = new ServiceProducto();

    @GetMapping("/productos/{id}")
    public Object getProducto(@PathVariable int id) {
        return serviceProducto.getProducto(id);
    }

    @GetMapping("/productos")
    public List<Objeto> getProductos() {
        return serviceProducto.getProductos();
    }
}
