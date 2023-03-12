package com.example.AwsEc2_Demo.service;


import com.example.AwsEc2_Demo.dao.IPostrepository;
import com.example.AwsEc2_Demo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Postservice {

    @Autowired
    IPostrepository postrepository;
    public void savepost(Post newpost) {
         postrepository.save(newpost);
    }

    public List<Post> getpost() {
        return postrepository.findAll();
    }
}
