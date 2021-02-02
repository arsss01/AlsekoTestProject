package com.project.alseko.repositories;

import com.project.alseko.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {

  @Transactional
  @Modifying
  @Query(value = "delete from employees_material_values " +
      "where employees_id = :id", nativeQuery = true)
  Integer deleteJoin(@Param("id") Integer id);
}
