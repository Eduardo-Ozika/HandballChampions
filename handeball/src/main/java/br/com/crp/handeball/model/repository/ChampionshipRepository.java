package br.com.crp.handeball.model.repository;


import br.com.crp.handeball.model.entity.Championship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChampionshipRepository extends CrudRepository<Championship,Long> {}
