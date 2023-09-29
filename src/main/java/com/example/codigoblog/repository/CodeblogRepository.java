package com.example.codigoblog.repository;

import com.example.codigoblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeblogRepository extends JpaRepository<Post, Long> {

}
