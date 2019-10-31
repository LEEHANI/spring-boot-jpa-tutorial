package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Post;
import com.example.demo.repositories.custom.PostRepositoryCustom;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom{

}
