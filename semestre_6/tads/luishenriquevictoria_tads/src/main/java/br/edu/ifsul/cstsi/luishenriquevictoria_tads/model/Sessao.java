package br.edu.ifsul.cstsi.luishenriquevictoria_tads.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "sessoes")
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_sessao", nullable = false)
    private LocalDate dataSessao;

    @Column(name = "hora_sessao", nullable = false)
    private LocalTime horaSessao;

    @Column(name = "valor_inteira", nullable = false)
    private Double valorInteira;

    @Column(name = "valor_meia", nullable = false)
    private Double valorMeia;

    @Column(name = "encerrada", nullable = false)
    private Boolean encerrada = false;

    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "filme_id", nullable = false)
    private Filme filme;

    @OneToMany(mappedBy = "sessao", cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    // Getters e Setters
}
