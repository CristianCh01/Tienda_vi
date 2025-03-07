package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        var categorias=categoriaService.getCategorias(false);
        model.addAttribute("categorias",categorias);
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        categoria =categoriaService.getCategoria(categoria);
        model.addAttribute("productos", categoria.getProductos());
        var categorias=categoriaService.getCategorias(false);
        model.addAttribute("categorias",categorias);
        return "/pruebas/listado";
    }
}
