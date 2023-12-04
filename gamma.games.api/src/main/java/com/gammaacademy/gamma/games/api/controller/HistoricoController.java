package com.gammaacademy.gamma.games.api.controller;

import com.gammaacademy.gamma.games.api.entities.Historico;
import com.gammaacademy.gamma.games.api.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    private final HistoricoService historicoService;

    @Autowired
    public HistoricoController(HistoricoService historicoService) {
        this.historicoService = historicoService;
    }

    // Endpoint para obter todos os historicos
    @GetMapping
    public List<Historico> getAllHistoricos() {
        return historicoService.getAllHistoricos();
    }

    // Endpoint para obter um historico pelo ID
    @GetMapping("/{id}")
    public Historico getHistoricoById(@PathVariable long id) {
        return historicoService.getHistoricoById(id);
    }

    // Endpoint para criar um novo historico
    @PostMapping
    public Historico createHistorico(@RequestBody Historico historico) {
        return historicoService.createHistorico(historico);
    }

    // Endpoint para atualizar um historico existente pelo ID
    @PutMapping("/{id}")
    public Historico updateHistorico(@PathVariable long id, @RequestBody Historico historico) {
        return historicoService.updateHistorico(id, historico);
    }

    // Endpoint para excluir um historico pelo ID
    @DeleteMapping("/{id}")
    public void deleteHistorico(@PathVariable long id) {
        historicoService.delete(id);
    }
}
