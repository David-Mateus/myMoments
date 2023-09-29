package com.example.codigoblog.service;

import com.example.codigoblog.model.Post;

import java.util.List;

public interface CodeblogService {
    void delete(Long id);
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post post);

}
