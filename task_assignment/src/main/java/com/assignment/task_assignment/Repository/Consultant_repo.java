package com.assignment.task_assignment.Repository;

import com.assignment.task_assignment.model.Consultant_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Consultant_repo extends JpaRepository<Consultant_table,Long> {

    Consultant_table findByName(String name);

    Consultant_table findByRole(String role);
}
