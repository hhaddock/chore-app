package com.atlas.menter.repository;

import com.atlas.menter.entity.Chore;
import org.springframework.data.repository.CrudRepository;

public interface ChoreRepository extends CrudRepository<Chore, Long> {
    Chore findByName(String name);
}
