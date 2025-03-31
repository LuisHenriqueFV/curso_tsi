package br.edu.ifsul.cstsi.luishenriquevictoria_tads.model;

import jakarta.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "duracao", nullable = false)
    private Duration duracao;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL)
    private List<Sessao> sessoes;

    // Getters e Setters
}