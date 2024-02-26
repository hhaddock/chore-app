package com.atlas.menter.repository;

import com.atlas.menter.entity.Chore;
import com.atlas.menter.entity.ChoreAssignment;
import com.atlas.menter.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface ChoreAssignmentRepository extends CrudRepository<ChoreAssignment, Long> {
    ChoreAssignment findCurrentChoreByAssignedUser(User user);
    ChoreAssignment findAssignedUserByCurrentChore(Chore chore);
}
