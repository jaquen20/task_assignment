package com.assignment.task_assignment.Repository;

import com.assignment.task_assignment.model.RequestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface requestTableRepo extends JpaRepository<RequestTable,Long> {

}
