
package com.example.demo.daoImpl;

import com.example.demo.dao.PostDao;
import com.example.demo.entity.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Docente
 */
@Component
public class PostDaoImpl implements PostDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int create(Post post) {
        String SQL="insert into post (titulo, descripcion) values(?,?)";
        return jdbcTemplate.update(SQL,new Object[]{post.getTitulo(),post.getDescripcion()});
    }

    @Override
    public int update(Post post) {
        String SQL="update post set titulo=?, descripcion=? where idpost=?";
        return jdbcTemplate.update(SQL,new Object[]{post.getTitulo(),post.getDescripcion(),post.getIdpost()});
    }

    @Override
    public int delete(int id) {
        String SQL="delete from post where idpost=?";
        return jdbcTemplate.update(SQL,new Object[]{id});
    }

    @Override
    public Post read(int id) {
        String SQL="select *from post where idpost=?";
        Post post = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Post.class), id);
        return post;
    }

    @Override
    public List<Post> readAll() {
        String SQL="select *from post";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Post.class));
        
    }
    
}
