package br.com.crp.handeballCamp.model.repository;


import br.com.crp.handeballCamp.model.entity.Stadium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StadiumRepository extends CrudRepository<Stadium,Long> {}
