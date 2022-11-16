package br.com.crp.handeballCamp.model.repository;


import br.com.crp.handeballCamp.model.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {}
