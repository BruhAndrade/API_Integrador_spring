package com.gammaacademy.gamma.games.api.controller;

import com.gammaacademy.gamma.games.api.dto.HistoricoDTO;
import com.gammaacademy.gamma.games.api.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    private final HistoricoService historicoService;

    @Autowired
    public HistoricoController(HistoricoService historicoService) {
        this.historicoService = historicoService;
    }

    @GetMapping
    public ResponseEntity<List<HistoricoDTO>> getAllHistoricos() {
        List<HistoricoDTO> historicos = historicoService.getAllHistoricosDTO();
        return new ResponseEntity<>(historicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoDTO> getHistoricoById(@PathVariable long id) {
        try {
            HistoricoDTO historico = historicoService.getHistoricoDTOById(id);
            return new ResponseEntity<>(historico, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<HistoricoDTO> createHistorico(@RequestBody HistoricoDTO historicoDTO) {
        HistoricoDTO createdHistorico = historicoService.createHistorico(historicoDTO);
        return new ResponseEntity<>(createdHistorico, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoDTO> updateHistorico(@PathVariable long id, @RequestBody HistoricoDTO historicoDTO) {
        try {
            HistoricoDTO updatedHistorico = historicoService.updateHistorico(id, historicoDTO);
            return new ResponseEntity<>(updatedHistorico, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorico(@PathVariable long id) {
        historicoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleEntityNotFoundException(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
