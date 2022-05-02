package com.upc.eccomerce.controllers;

import com.upc.eccomerce.entities.Reto;
import com.upc.eccomerce.services.RetosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reto")
public class RetosController {


    private RetosService retosService;

    public RetosController(RetosService retosService){
        this.retosService = retosService;
    }

    @PostMapping
    public ResponseEntity<Reto> createRetos(@RequestBody Reto retos){
        return new ResponseEntity<Reto>(retosService.createdRetos(retos), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Reto> updateRetos(@RequestBody Reto retos){
        return new ResponseEntity<Reto>(retosService.createdRetos(retos), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteRetos(@PathVariable Integer id){
        retosService.deleteRetos(id);
    }


}
