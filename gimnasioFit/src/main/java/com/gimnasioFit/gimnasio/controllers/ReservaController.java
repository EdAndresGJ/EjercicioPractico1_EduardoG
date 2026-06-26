/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.gimnasioFit.gimnasio.controllers;

import com.gimnasioFit.gimnasio.domain.Reserva;
import com.gimnasioFit.gimnasio.service.ReservaService;
import com.gimnasioFit.gimnasio.service.ServicioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ServicioService servicioService;

    public ReservaController(
            ReservaService reservaService,
            ServicioService servicioService) {

        this.reservaService = reservaService;
        this.servicioService = servicioService;
    }

    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute(
                "reservas",
                reservaService.listarReservas()
        );

        return "reserva/listado";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());

        model.addAttribute(
                "servicios",
                servicioService.listarServicios()
        );

        return "reserva/formulario";
    }

    @PostMapping("/guardar")
    public String guardarReserva(Reserva reserva) {
        reservaService.guardarReserva(reserva);

        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String editarReserva(
            @PathVariable Integer id,
            Model model) {

        model.addAttribute(
                "reserva",
                reservaService.buscarReservaPorId(id)
        );

        model.addAttribute(
                "servicios",
                servicioService.listarServicios()
        );

        return "reserva/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);

        return "redirect:/reservas";
    }
}
