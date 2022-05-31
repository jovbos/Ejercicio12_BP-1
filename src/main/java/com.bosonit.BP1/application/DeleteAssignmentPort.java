package com.bosonit.BP1.application;

import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.springframework.http.ResponseEntity;

public interface DeleteAssignmentPort {

    public ResponseEntity<AssignmentOutputDTO> deleteAssignment(Integer id) throws Exception;
}
