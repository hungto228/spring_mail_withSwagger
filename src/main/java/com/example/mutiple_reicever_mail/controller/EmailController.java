package com.example.mutiple_reicever_mail.controller;

import com.example.mutiple_reicever_mail.MailContructor;
import com.example.mutiple_reicever_mail.jsonmapper.JsonMapperToPojo;
import com.example.mutiple_reicever_mail.model.User;
import com.example.mutiple_reicever_mail.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailController {
    @Autowired
    JsonMapperToPojo jsonMapperToPojo;
    @Autowired
    MailContructor mailContructor;
    @Autowired
    UserRepository userRepository;
    @ApiOperation(value = "send a mail")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
 //   @PostMapping(value = "sendemail",consumes = "application/json")
   @PostMapping("/sendemail")
    public  void sendEmail(@RequestBody String emailSubjectAndBody) throws MessagingException, IOException{
    mailContructor.sendmail(jsonMapperToPojo.eMailJsonToPojo(emailSubjectAndBody));
    }
    @GetMapping("/users")
    public Page<User> getAllusers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
