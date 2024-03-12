package com.assignment.task_assignment.controller;

import com.assignment.task_assignment.Service.Consultant_service;
import com.assignment.task_assignment.Service.RequestTableService;
import com.assignment.task_assignment.model.Consultant_table;
import com.assignment.task_assignment.model.RequestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class Admin_controller {
    @Autowired
    Consultant_service consultantService;
    @Autowired
    RequestTableService requestTableService;

    //for getting all the requested list for consultant
    @GetMapping("/req_list")
    ResponseEntity<List<RequestTable>> requestList(){
        try {
            List<RequestTable> ct = requestTableService.getRequestList();
            return ResponseEntity.ok(ct);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }
    }

    //for getting total numbers of the consultants approved
    @GetMapping("/total")
    ResponseEntity<Long> statistics(){
        try {
            Long ct = consultantService.getNo();
            return ResponseEntity.ok(ct);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(null);

        }
    }

    //for getting all the consultants  list that are approved
    @GetMapping("/allData")
    ResponseEntity<List<Consultant_table>> AcceptedList(){
        try {
            List<Consultant_table> ct = consultantService.getAcceptedList();
            return ResponseEntity.ok(ct);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }
    }



//accepting or approving a consultant by its id
    @PostMapping("/approve/{id}")
    ResponseEntity<String> ApproveRequest(@PathVariable Long id){
        try{
            requestTableService.approve(id);
            return ResponseEntity.ok("success");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("data with id="+id+" not found");

        }


    }

    //rejecting a request by its id
    @PostMapping("/reject/{id}")
    ResponseEntity<String> RejectRequest(@PathVariable Long id){
        try{
            requestTableService.reject(id);
            return ResponseEntity.ok("success");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("data with id="+id+" not found");

        }

    }

    //searching individual consultant by name
    @GetMapping("/search/name/{name}")
    ResponseEntity<Consultant_table> ConsultantByName(@PathVariable String name){
try{
    Consultant_table ct=consultantService.getDataByName(name);
    return ResponseEntity.ok(ct);

}catch(Exception exception){
    throw new RuntimeException("data with name= " + name +" not found");
}
    }

    //searching individual consultant by role
    @GetMapping("/search/role/{role}")
    ResponseEntity<Consultant_table> ConsultantByRole(@PathVariable String role){
        try{
            Consultant_table ct=consultantService.getDataByRole(role);
            return ResponseEntity.ok(ct);

        }catch(Exception exception){
            throw new RuntimeException("data with name= " + role +" not found");
        }
    }

}

