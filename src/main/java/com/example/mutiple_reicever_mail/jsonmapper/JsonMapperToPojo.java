package com.example.mutiple_reicever_mail.jsonmapper;

import com.example.mutiple_reicever_mail.model.Email;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonMapperToPojo {
    private ObjectMapper mapper=new ObjectMapper();
    public Email eMailJsonToPojo(String userJson) throws IOException{
        return mapper.readValue(userJson,Email.class);
    }
}
