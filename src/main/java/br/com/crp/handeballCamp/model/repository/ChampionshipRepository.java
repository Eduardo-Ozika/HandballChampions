package br.com.crp.handeballCamp.model.repository;



import br.com.crp.handeballCamp.model.entity.Championship;
cimport org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends ReactiveCrudRepository<Championship,Long>{
}
