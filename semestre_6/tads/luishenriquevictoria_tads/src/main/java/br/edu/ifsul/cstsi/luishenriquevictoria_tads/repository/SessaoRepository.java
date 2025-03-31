package br.edu.ifsul.cstsi.luishenriquevictoria_tads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    List<Sessao> findByDataSessaoAndEncerradaFalse(LocalDate data);
}