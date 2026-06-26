/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.gimnasioFit.gimnasio.serviceimpl;

import com.gimnasioFit.gimnasio.domain.Categoria;
import com.gimnasioFit.gimnasio.repository.CategoriaRepository;
import com.gimnasioFit.gimnasio.service.CategoriaService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
