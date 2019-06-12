package br.ufjf.dcc193.tomatoban;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
    List<Atividade> findByDificuldade(Integer dificuldade);
    List<Atividade> findByDificuldadeBetween(Integer min, Integer max);
    @Query("SELECT a FROM Atividade a WHERE a.tomatoes>5")
    List<Atividade> listaGrandes();

}