package com.bosonit.BP1.application;

import com.bosonit.BP1.domain.Assignment;
import com.bosonit.BP1.domain.repository.AssignmentRepositoryJPA;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAssignmentUseCase implements GetAssignmentPort {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AssignmentRepositoryJPA repository;

    public ResponseEntity<AssignmentOutputDTO> getAssignmentId(Integer id) throws Exception {

        if (repository.findById(id).isEmpty()) return ResponseEntity.status(404).build();
        else {
            Assignment assignment = repository.findById(id).orElseThrow(() -> new Exception("Assignment not registered."));
            AssignmentOutputDTO assignmentOut = modelMapper.map(assignment, AssignmentOutputDTO.class);

            return ResponseEntity.ok().body(assignmentOut);
        }
    }

    public List<AssignmentOutputDTO> getAssignmentName(String name) {

        List<AssignmentOutputDTO> listDTO = new ArrayList<>();
        List<Assignment> assignmentList = repository.findByName(name);
        assignmentList.forEach(p -> {
            AssignmentOutputDTO assignmentOutputDTO = modelMapper.map(p, AssignmentOutputDTO.class);
            listDTO.add(assignmentOutputDTO);
        });

        return listDTO;
    }
    public List<AssignmentOutputDTO> getAssignmentAll() {

        List<AssignmentOutputDTO> listDTO = new ArrayList<>();
        List<Assignment> assignmentList = repository.findAll();
        assignmentList.forEach(p -> {
            AssignmentOutputDTO assignmentOutputDTO = modelMapper.map(p, AssignmentOutputDTO.class);
            listDTO.add(assignmentOutputDTO);
        });

        return listDTO;
    }


}
