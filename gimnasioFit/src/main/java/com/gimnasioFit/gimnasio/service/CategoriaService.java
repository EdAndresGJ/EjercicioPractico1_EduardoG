/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gimnasioFit.gimnasio.service;

import com.gimnasioFit.gimnasio.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> listarCategorias();

    Categoria buscarCategoriaPorId(Integer id);

    void guardarCategoria(Categoria categoria);

    void eliminarCategoria(Integer id);
}
