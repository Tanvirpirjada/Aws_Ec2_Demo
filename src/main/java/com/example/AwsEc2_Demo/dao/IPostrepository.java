package com.example.AwsEc2_Demo.dao;


import com.example.AwsEc2_Demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostrepository extends JpaRepository<Post, Integer> {
}
