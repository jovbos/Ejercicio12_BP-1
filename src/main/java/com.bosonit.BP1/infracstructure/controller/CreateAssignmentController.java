package com.bosonit.BP1.infracstructure.controller;

import com.bosonit.BP1.application.CreateAssignmentPort;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateAssignmentController {

    @Autowired
    CreateAssignmentPort createPort;

    @PostMapping("/assignment")
    public AssignmentOutputDTO createAssigment(@RequestBody AssignmentInputDTO assignmentDTO) throws Exception {

        return createPort.addAssignment(assignmentDTO);

    }

}
