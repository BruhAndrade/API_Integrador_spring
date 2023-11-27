package com.gammaacademy.gamma.games.api.controller;

import com.gammaacademy.gamma.games.api.entities.Jogo;
import com.gammaacademy.gamma.games.api.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Jogo> getAllJogos() {
        return jogoService.getAllJogos();
    }

    @GetMapping("/{id}")
    public Jogo getJogoById(@PathVariable long id) {
        return jogoService.getJogoById(id);
    }

    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return jogoService.createJogo(jogo);
    }

    @PutMapping("/{id}")
    public Jogo updateJogo(@PathVariable long id, @RequestBody Jogo jogo) {
        return jogoService.updateJogo(id, jogo);
    }

    @DeleteMapping("/{id}")
    public void deleteJogo(@PathVariable long id) {
        jogoService.deleteJogo(id);
    }
}
