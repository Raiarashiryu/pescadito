package com.example.pescadito.service;
import com.example.pescadito.model.Combinado;
import com.example.pescadito.repository.CombinadoRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CombinadoService {
    private final CombinadoRepository combinadoRepository;

    public CombinadoService(CombinadoRepository combinadoRepository1) {
        this.combinadoRepository = combinadoRepository1;

    }

    //listado de todos los combinados
    public List<Combinado> ListarTodas() {
        return combinadoRepository.findAll();
    }

    //busqueda por id
    public Optional<Combinado> buscarPorId(Integer id) {
        return combinadoRepository.findById(id);
    }

    //crear combinado
    public Combinado crearCombinado(Combinado combinado) {
        return combinadoRepository.save(combinado);

    }

    //actualizar combinado
    public Combinado actualizarCombinado(Integer id, Combinado combiado) {
        combiado.setId(id);
        return combinadoRepository.save(combiado);

    }

    //eliminar combinado
    public void eliminarCombinado(Integer id) {
        combinadoRepository.deleteById(id);
    }


    // buscar por diponibilidad

}



