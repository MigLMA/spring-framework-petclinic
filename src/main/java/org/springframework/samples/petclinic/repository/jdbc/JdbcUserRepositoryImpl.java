package org.springframework.samples.petclinic.repository.jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.repository.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 628700
 */
@Repository
public class JdbcUserRepositoryImpl implements UserRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertUser;

    @Autowired
    public JdbcUserRepositoryImpl(DataSource dataSource) {

        this.insertUser = new SimpleJdbcInsert(dataSource)
            .withTableName("Users")
            .usingGeneratedKeyColumns("id");

        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }


    /**
     * 
     */
    @Override
    public User findByUsername(String userName) throws DataAccessException {
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName + "%");
        List<User> users = this.namedParameterJdbcTemplate.query(
            "SELECT id, username FROM Users WHERE username like :userName",
            params,
            BeanPropertyRowMapper.newInstance(User.class)
        );
        return users.get(0);
    }


}
