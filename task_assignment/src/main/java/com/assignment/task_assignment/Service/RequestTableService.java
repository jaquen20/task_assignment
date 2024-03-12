package com.assignment.task_assignment.Service;

import com.assignment.task_assignment.Exceptions.EmptyListException;
import com.assignment.task_assignment.Exceptions.NotFoundException;
import com.assignment.task_assignment.Repository.Consultant_repo;
import com.assignment.task_assignment.Repository.requestTableRepo;
import com.assignment.task_assignment.model.Consultant_table;
import com.assignment.task_assignment.model.RequestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestTableService {
    @Autowired
    requestTableRepo requestTableRepo;
    @Autowired
    Consultant_repo consultantRepo;


    public List<RequestTable> getRequestList() {
        List<RequestTable> requestList = requestTableRepo.findAll();

        if (requestList.isEmpty()) {
            throw new EmptyListException("Request list is empty");
        }else {
            return requestTableRepo.findAll();
        }

    }

    public void PostData(RequestTable requestTable) {
        try {
            requestTableRepo.save(requestTable);
        }catch (Exception e){
            throw new RuntimeException("Error ", e);
        }
    }



    public void reject(Long id) {
        try {
            Optional<RequestTable> requestTable = requestTableRepo.findById(id);
            if (requestTable.isPresent()) {
                requestTableRepo.deleteById(id);
            } else {
                throw new NotFoundException("Request with ID " + id + " not found");
            }
        }catch (Exception | NotFoundException exception){
            throw new RuntimeException("Error approving request", exception);

        }
    }


    public void approve(Long id) {
        try {
            Optional<RequestTable> requestTable = requestTableRepo.findById(id);
            if (requestTable.isPresent()) {
                Consultant_table ct = new Consultant_table();
                RequestTable rq = requestTable.get();
                ct.setName(rq.getName());
                ct.setAge(rq.getAge());
                ct.setAddress(rq.getAddress());
                ct.setCv(rq.getCv());
                ct.setMobile_no(rq.getMobile_no());
                ct.setRole(rq.getRole());
                consultantRepo.save(ct);
                requestTableRepo.deleteById(id);
            } else {
                throw new NotFoundException("Request with ID " + id + " not found");
            }
        }catch (Exception | NotFoundException exception){
            throw new RuntimeException("Error approving request", exception);

        }


    }
}
