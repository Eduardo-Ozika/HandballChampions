package br.com.crp.handeball.model.repository;


import br.com.crp.handeball.model.entity.Stadium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StadiumRepository extends CrudRepository<Stadium,Long> {}
