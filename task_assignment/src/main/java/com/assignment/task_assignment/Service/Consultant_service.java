package com.assignment.task_assignment.Service;

import com.assignment.task_assignment.Exceptions.EmptyListException;
import com.assignment.task_assignment.Exceptions.NotFoundException;
import com.assignment.task_assignment.Repository.Consultant_repo;
import com.assignment.task_assignment.model.Consultant_table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Consultant_service {
    @Autowired
    Consultant_repo consultantRepo;



    public List<Consultant_table> getAcceptedList() {
        try {
            List<Consultant_table> consultantList = consultantRepo.findAll();

            if (consultantList.isEmpty()) {
                throw new EmptyListException("No consultants found");
            }
            return consultantList;
        }catch (Exception exception){
            throw new RuntimeException("error",exception);
        }
    }

    public Long getNo() {
        try{
        return consultantRepo.count();
        }catch (Exception exception){
            throw new RuntimeException("Error occurred",exception);
        }
    }
    public Consultant_table getDataByName(String name) {
        try{
            Optional<Consultant_table> consultantOptional = Optional.ofNullable(consultantRepo.findByName(name));
            if (consultantOptional.isPresent()){
                return consultantOptional.get();
            }
            else{
                throw new NotFoundException("Consultant with name " + name + " not found");

            }
        }
       catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
        catch(Exception exception){
            throw exception;

        }
    }

    public Consultant_table getDataByRole(String role) {

        try{
            Optional<Consultant_table> consultantOptional = Optional.ofNullable(consultantRepo.findByRole(role));
            if (consultantOptional.isPresent()){
                return consultantOptional.get();
            }
            else{
                throw new NotFoundException("Consultant with role " + role + " not found");

            }
        } catch (Exception | NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
