package br.edu.ifsul.cstsi.luishenriquevictoria_tads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
    Long countBySessaoAndTipo(Sessao sessao, TipoIngresso tipo);
}