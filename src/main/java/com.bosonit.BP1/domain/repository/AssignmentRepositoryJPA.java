package com.bosonit.BP1.domain.repository;

import com.bosonit.BP1.domain.Assignment;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepositoryJPA  extends JpaRepository<Assignment, Integer> {
    List<Assignment> findByName(String name);
}
