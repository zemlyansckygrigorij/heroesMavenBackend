package com.backend.repository;

import com.backend.model.Hero;
import org.springframework.data.repository.CrudRepository;


import java.util.Collection;

public interface HeroRepository extends CrudRepository<Hero, Long>{
    Collection<Hero> findAll();
}
