package com.assignment.task_assignment.controller;

import com.assignment.task_assignment.Service.RequestTableService;
import com.assignment.task_assignment.model.RequestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consultant_controller {
    @Autowired
    RequestTableService requestTableService;

    //requesting for consultant
    @PostMapping("/request")
    ResponseEntity<String> postRequest(@RequestBody RequestTable requestTable){
        try{
            requestTableService.PostData(requestTable);
            return ResponseEntity.ok("success");
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occurred");

        }

    }
}
