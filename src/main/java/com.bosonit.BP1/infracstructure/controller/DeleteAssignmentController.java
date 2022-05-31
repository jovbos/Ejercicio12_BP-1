package com.bosonit.BP1.infracstructure.controller;

import com.bosonit.BP1.application.DeleteAssignmentPort;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAssignmentController {

    @Autowired
    DeleteAssignmentPort deletePort;

    @DeleteMapping("/assignment/{id}")
    public ResponseEntity<AssignmentOutputDTO> deleteAssignment(@PathVariable Integer id) throws Exception {

        return deletePort.deleteAssignment(id);
    }
}
