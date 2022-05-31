package com.bosonit.BP1.application;

import com.bosonit.BP1.infracstructure.controller.dto.AssignmentInputDTO;
import com.bosonit.BP1.infracstructure.controller.dto.AssignmentOutputDTO;

public interface CreateAssignmentPort {
    public AssignmentOutputDTO addAssignment(AssignmentInputDTO assignmentDTO) throws Exception ;
}
