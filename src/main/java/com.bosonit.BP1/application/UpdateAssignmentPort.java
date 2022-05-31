package com.bosonit.BP1.application;

import com.bosonit.BP1.infracstructure.controller.dto.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;
import org.springframework.http.ResponseEntity;

public interface UpdateAssignmentPort {

    public ResponseEntity<AssignmentOutputDTO> updateAssignment (Integer id, AssignmentInputDTO assignmentDTO);
}
