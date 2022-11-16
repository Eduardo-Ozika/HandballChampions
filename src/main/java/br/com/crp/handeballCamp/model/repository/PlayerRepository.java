package br.com.crp.handeballCamp.model.repository;


import br.com.crp.handeballCamp.model.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {
}
