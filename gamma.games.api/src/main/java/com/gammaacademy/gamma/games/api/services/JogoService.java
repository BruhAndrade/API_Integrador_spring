package com.gammaacademy.gamma.games.api.services;

import com.gammaacademy.gamma.games.api.dto.JogoDTO;
import com.gammaacademy.gamma.games.api.entities.Jogo;
import com.gammaacademy.gamma.games.api.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<JogoDTO> getAllJogosDTO() {
        return jogoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public Jogo findById(Long id) {
        Optional<Jogo> optionalJogo = jogoRepository.findById(id);
        return optionalJogo.orElse(null);
    }
    public JogoDTO getJogoDTOById(long id) {
        return convertToDTO(jogoRepository.findById(id).orElse(null));
    }

    public JogoDTO createJogo(JogoDTO jogoDTO) {
        Jogo jogo = convertToEntity(jogoDTO);
        Jogo savedJogo = jogoRepository.save(jogo);

        // Atualize o ID no objeto JogoDTO
        jogoDTO.setId(savedJogo.getId());

        return jogoDTO;
    }



    public void deleteJogo(long id) {
        jogoRepository.deleteById(id);
    }

    public JogoDTO updateJogo(long id, JogoDTO jogoDTO) {
        if (jogoRepository.existsById(id)) {
            Jogo jogo = convertToEntity(jogoDTO);
            jogo.setId(id);
            return convertToDTO(jogoRepository.save(jogo));
        }
        return null;
    }

    private JogoDTO convertToDTO(Jogo jogo) {
        JogoDTO jogoDTO = new JogoDTO();
        jogoDTO.setId(jogo.getId());
        jogoDTO.setNomeJogo(jogo.getNomeJogo());
        jogoDTO.setNomeAutor(jogo.getNomeAutor());
        jogoDTO.setSiteJogo(jogo.getSiteJogo());
        return jogoDTO;
    }


    private Jogo convertToEntity(JogoDTO jogoDTO) {
        Jogo jogo = new Jogo();
        jogo.setNomeJogo(jogoDTO.getNomeJogo());
        jogo.setNomeAutor(jogoDTO.getNomeAutor());
        jogo.setSiteJogo(jogoDTO.getSiteJogo());
        return jogo;
    }
}
