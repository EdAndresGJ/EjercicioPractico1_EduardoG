/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.gimnasioFit.gimnasio.controllers;

import com.gimnasioFit.gimnasio.domain.Servicio;
import com.gimnasioFit.gimnasio.service.CategoriaService;
import com.gimnasioFit.gimnasio.service.ServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService servicioService;
    private final CategoriaService categoriaService;

    public ServicioController(
            ServicioService servicioService,
            CategoriaService categoriaService) {

        this.servicioService = servicioService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listarServicios(Model model) {
        model.addAttribute(
                "servicios",
                servicioService.listarServicios()
        );

        return "servicio/listado";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("servicio", new Servicio());

        model.addAttribute(
                "categorias",
                categoriaService.listarCategorias()
        );

        return "servicio/formulario";
    }

    @PostMapping("/guardar")
    public String guardarServicio(Servicio servicio) {
        servicioService.guardarServicio(servicio);

        return "redirect:/servicios";
    }

    @GetMapping("/editar/{id}")
    public String editarServicio(
            @PathVariable Integer id,
            Model model) {

        model.addAttribute(
                "servicio",
                servicioService.buscarServicioPorId(id)
        );

        model.addAttribute(
                "categorias",
                categoriaService.listarCategorias()
        );

        return "servicio/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Integer id) {
        servicioService.eliminarServicio(id);

        return "redirect:/servicios";
    }
}
