package com.example.AwsEc2_Demo.contoller;


import com.example.AwsEc2_Demo.model.Post;
import com.example.AwsEc2_Demo.service.Postservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Postcontoller {

    @Autowired
    Postservice postservice;


    @PostMapping("createpost")
    public ResponseEntity createpost(@RequestBody Post newpost){
        postservice.savepost(newpost);
        return new ResponseEntity("post saved", HttpStatus.CREATED);
    }


    @GetMapping("geposts")
    public List<Post> getpost(){
        return postservice.getpost();
    }
}
