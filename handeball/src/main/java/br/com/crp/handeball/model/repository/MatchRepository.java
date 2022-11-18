package br.com.crp.handeball.model.repository;



import br.com.crp.handeball.model.entity.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {

}
