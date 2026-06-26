/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gimnasioFit.gimnasio.service;

import com.gimnasioFit.gimnasio.domain.Reserva;
import java.util.List;

public interface ReservaService {

    List<Reserva> listarReservas();

    Reserva buscarReservaPorId(Integer id);

    void guardarReserva(Reserva reserva);

    void eliminarReserva(Integer id);
}
