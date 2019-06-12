package br.ufjf.dcc193.tomatoban;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String titulo;
    @PositiveOrZero
    private Integer tomatoes;

    @Min(1)
    @Max(5)
    private Integer dificuldade;

    @OneToMany(mappedBy = "atividade")
    List<Tomato> tomatoList;

    public Atividade(){
        this.dificuldade = 3;
        this.tomatoList = new ArrayList<>();
    }
    

    public Atividade(String titulo){
        this();
        setTitulo(titulo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(Integer tomatoes) {
        this.tomatoes = tomatoes;
    }

    @Override
    public String toString() {
        return "Atividade [id=" + id + ", titulo=" + titulo + ", tomatoes=" + tomatoes + "]";
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<Tomato> getTomatoList() {
        return tomatoList;
    }

    public void setTomatoList(List<Tomato> tomatoList) {
        this.tomatoList = tomatoList;
    }
    
    
}