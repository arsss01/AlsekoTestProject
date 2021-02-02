package com.project.alseko.repositories;

import com.project.alseko.entity.MaterialValuesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MaterialValuesRepository extends CrudRepository<MaterialValuesEntity, Integer> {

    @Query("select sum(cost) from material_values")
    Integer getCommonCostOfValues();

}
