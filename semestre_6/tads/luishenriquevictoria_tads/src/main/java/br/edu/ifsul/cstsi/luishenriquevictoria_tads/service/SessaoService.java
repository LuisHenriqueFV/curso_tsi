package br.edu.ifsul.cstsi.luishenriquevictoria_tads.service;

import br.edu.ifsul.cstsi.luishenriquevictoria_tads.model.Filme;
import br.edu.ifsul.cstsi.luishenriquevictoria_tads.model.Sala;
import br.edu.ifsul.cstsi.luishenriquevictoria_tads.model.Sessao;
import br.edu.ifsul.cstsi.luishenriquevictoria_tads.repository.FilmeRepository;
import br.edu.ifsul.cstsi.luishenriquevictoria_tads.repository.SalaRepository;
import br.edu.ifsul.cstsi.luishenriquevictoria_tads.repository.SessaoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class SessaoService {
    private final SessaoRepository sessaoRepository;
    private final SalaRepository salaRepository;
    private final FilmeRepository filmeRepository;

    public SessaoService(
            SessaoRepository sessaoRepository,
            SalaRepository salaRepository,
            FilmeRepository filmeRepository
    ) {
        this.sessaoRepository = sessaoRepository;
        this.salaRepository = salaRepository;
        this.filmeRepository = filmeRepository;
    }

    public Sessao criarSessao(
            Long filmeId,
            Long salaId,
            LocalDate data,
            LocalTime hora,
            Double valorInteira,
            Double valorMeia
    ) {
        Filme filme = filmeRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        Sala sala = salaRepository.findById(salaId)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        Sessao sessao = new Sessao();
        sessao.setFilme(filme);
        sessao.setSala(sala);
        sessao.setDataSessao(data);
        sessao.setHoraSessao(hora);
        sessao.setValorInteira(valorInteira);
        sessao.setValorMeia(valorMeia);

        return sessaoRepository.save(sessao);
    }
}