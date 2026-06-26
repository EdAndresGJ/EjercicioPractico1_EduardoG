/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.gimnasioFit.gimnasio.controllers;

import com.gimnasioFit.gimnasio.domain.Categoria;
import com.gimnasioFit.gimnasio.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute(
                "categorias",
                categoriaService.listarCategorias()
        );

        return "categoria/listado";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("categoria", new Categoria());

        return "categoria/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.guardarCategoria(categoria);

        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(
            @PathVariable Integer id,
            Model model) {

        model.addAttribute(
                "categoria",
                categoriaService.buscarCategoriaPorId(id)
        );

        return "categoria/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);

        return "redirect:/categorias";
    }
}
