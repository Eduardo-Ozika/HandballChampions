package br.com.crp.handeball.model.repository;


import br.com.crp.handeball.model.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {}
