package com.bosonit.BP1.application;

import com.bosonit.BP1.domain.Assignment;
import com.bosonit.BP1.domain.repository.AssignmentRepositoryJPA;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class UpdateAssignmentUseCase implements UpdateAssignmentPort{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepositoryJPA repository;

    public ResponseEntity<AssignmentOutputDTO> updateAssignment (Integer id, AssignmentInputDTO assignmentDTO) {

        if (repository.findById(id).isEmpty()) return ResponseEntity.status(406).build();
            else{
              Assignment assignment = modelMapper.map(assignmentDTO, Assignment.class);
              assignment.setId(id);
              repository.save(assignment);

              AssignmentOutputDTO assignmentOut = modelMapper.map(assignment, AssignmentOutputDTO.class);

              return ResponseEntity.ok().body(assignmentOut);
         }
    }
}
