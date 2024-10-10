package com.example.demo.serviceImpl;

import com.example.demo.dao.PostDao;
import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Docente
 */
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostDao dao;
    
    @Override
    public int create(Post post) {
        return dao.create(post);
    }

    @Override
    public int update(Post post) {
        return dao.update(post);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Post read(int id) {
        return dao.read(id);
    }

    @Override
    public List<Post> readAll() {
        return dao.readAll();
    }
    
}
