/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gimnasioFit.gimnasio.service;

import com.gimnasioFit.gimnasio.domain.Servicio;
import java.util.List;

public interface ServicioService {

    List<Servicio> listarServicios();

    Servicio buscarServicioPorId(Integer id);

    void guardarServicio(Servicio servicio);

    void eliminarServicio(Integer id);
}