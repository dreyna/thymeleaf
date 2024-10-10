
package com.example.demo.dao;

import com.example.demo.entity.Post;
import java.util.List;

/**
 *
 * @author Docente
 */
public interface PostDao {
    public int create(Post post);
    public int update(Post post);
    public int delete(int id);
    public Post read(int id);
    public List<Post> readAll();
}
