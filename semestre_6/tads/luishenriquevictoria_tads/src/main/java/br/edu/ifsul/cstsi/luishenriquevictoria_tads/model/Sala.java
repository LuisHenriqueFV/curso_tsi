package br.edu.ifsul.cstsi.luishenriquevictoria_tads.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "capacidade", nullable = false)
    private Integer capacidade;

    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<Sessao> sessoes;

    // Getters e Setters
}