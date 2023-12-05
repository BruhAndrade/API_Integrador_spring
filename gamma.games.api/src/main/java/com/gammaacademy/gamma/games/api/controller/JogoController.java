package com.gammaacademy.gamma.games.api.controller;

import com.gammaacademy.gamma.games.api.dto.JogoDTO;
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
    public List<JogoDTO> getAllJogos() {
        return jogoService.getAllJogosDTO();
    }

    @GetMapping("/{id}")
    public JogoDTO getJogoById(@PathVariable long id) {
        return jogoService.getJogoDTOById(id);
    }

    @PostMapping
    public JogoDTO createJogo(@RequestBody JogoDTO jogoDTO) {
        return jogoService.createJogo(jogoDTO);
    }

    @PutMapping("/{id}")
    public JogoDTO updateJogo(@PathVariable long id, @RequestBody JogoDTO jogoDTO) {
        return jogoService.updateJogo(id, jogoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteJogo(@PathVariable long id) {
        jogoService.deleteJogo(id);
    }
}
