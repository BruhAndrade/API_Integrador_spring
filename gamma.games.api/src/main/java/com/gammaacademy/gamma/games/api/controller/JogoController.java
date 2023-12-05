package com.gammaacademy.gamma.games.api.controller;

import com.gammaacademy.gamma.games.api.dto.JogoDTO;
import com.gammaacademy.gamma.games.api.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public ResponseEntity<List<JogoDTO>> getAllJogos() {
        List<JogoDTO> jogos = jogoService.getAllJogosDTO();
        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoDTO> getJogoById(@PathVariable long id) {
        JogoDTO jogo = jogoService.getJogoDTOById(id);
        return new ResponseEntity<>(jogo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JogoDTO> createJogo(@RequestBody JogoDTO jogoDTO) {
        JogoDTO createdJogo = jogoService.createJogo(jogoDTO);
        return new ResponseEntity<>(createdJogo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoDTO> updateJogo(@PathVariable long id, @RequestBody JogoDTO jogoDTO) {
        JogoDTO updatedJogo = jogoService.updateJogo(id, jogoDTO);
        return new ResponseEntity<>(updatedJogo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJogo(@PathVariable long id) {
        jogoService.deleteJogo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
