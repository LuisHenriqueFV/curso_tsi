package br.edu.ifsul.cstsi.luishenriquevictoria_tads.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingressos")
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo", nullable = false)
    private TipoIngresso tipo;

    @ManyToOne
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;

    // Getters e Setters
}

public enum TipoIngresso {
    INTEIRA,
    MEIA
}
