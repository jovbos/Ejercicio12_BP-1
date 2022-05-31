package com.bosonit.BP1.application;

import com.bosonit.BP1.domain.Assignment;
import com.bosonit.BP1.domain.repository.AssignmentRepositoryJPA;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateAssignmentUseCase implements CreateAssignmentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepositoryJPA repository;

    public AssignmentOutputDTO addAssignment(AssignmentInputDTO assignmentDTO) throws Exception{

        Assignment assignment = modelMapper.map(assignmentDTO, Assignment.class);

        if (assignment.getName() == null) {throw new Exception("A name must been introduced");}
        repository.save(assignment);

        return modelMapper.map(assignment, AssignmentOutputDTO.class);
    }
}
