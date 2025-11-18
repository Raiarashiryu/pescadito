package com.example.pescadito.controller;
import com.example.pescadito.model.Combinado;
import com.example.pescadito.service.CombinadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pescadito")
public class Combinadocontroller {

    private final CombinadoService combinadoService;

    public Combinadocontroller(CombinadoService combinadoService){
        this.combinadoService = combinadoService;
    }

    @GetMapping
    public List<Combinado> obtenerCombinado(){
        return combinadoService.ListarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combinado>
    obtenerCombinadoPorId(@PathVariable Integer id){
        return combinadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?>
    crearMascota(@RequestBody Combinado combinado){
        if(combinado.getNombre() == null || combinado.getNombre().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo nombre es obligatorio");
        }
        if(combinado.getPrecio() == null ){
            return ResponseEntity.badRequest().body("El campo precio es obligatorio");
        }

        if(combinado.getDescripcion() == null || combinado.getDescripcion().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo descripcion es obligatorio");
        }
        if(combinado.getCategoria() == null ){
            return ResponseEntity.badRequest().body("El campo Peso es obligatorio");
        }
        return ResponseEntity.ok(combinadoService.crearCombinado(combinado));

    }



}