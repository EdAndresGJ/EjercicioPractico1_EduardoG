/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.gimnasioFit.gimnasio.serviceimpl;

import com.gimnasioFit.gimnasio.domain.Reserva;
import com.gimnasioFit.gimnasio.repository.ReservaRepository;
import com.gimnasioFit.gimnasio.service.ReservaService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva buscarReservaPorId(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}
