package br.com.crp.handeball.model.repository;


import br.com.crp.handeball.model.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {
}
