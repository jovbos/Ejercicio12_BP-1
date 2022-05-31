package com.bosonit.BP1.application;

import com.bosonit.BP1.domain.Assignment;
import com.bosonit.BP1.domain.repository.AssignmentRepositoryJPA;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteAssignmentUseCase  implements DeleteAssignmentPort{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepositoryJPA repository;

    public ResponseEntity<AssignmentOutputDTO> deleteAssignment(Integer id)  throws Exception {
    if (repository.findById(id).isEmpty()) return ResponseEntity.status(406).build();
    else {
          Assignment assignment = repository.findById(id).orElseThrow(() -> new Exception("Assignment not registered."));
          repository.delete(assignment);

          return ResponseEntity.ok().build();
        }
    }
}
