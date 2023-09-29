package com.example.codigoblog.service.serviceImpl;

import com.example.codigoblog.model.Post;
import com.example.codigoblog.repository.CodeblogRepository;
import com.example.codigoblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogServiceImpl implements CodeblogService {

    @Autowired
    private CodeblogRepository codeblogRepository;

    @Override
    public void delete(Long id){
        codeblogRepository.deleteById(id);
    }
    @Override
    public List<Post> findAll() {
        return codeblogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeblogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeblogRepository.save(post);
    }
}
