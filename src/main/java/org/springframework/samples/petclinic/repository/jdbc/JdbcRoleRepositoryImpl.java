package org.springframework.samples.petclinic.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.samples.petclinic.model.Role;
import org.springframework.samples.petclinic.repository.auth.RoleRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 628700
 * @since 04.10.2017
 */
@Repository
public class JdbcRoleRepositoryImpl implements RoleRepository {

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private SimpleJdbcInsert insertRole;

  @Autowired
  public JdbcRoleRepositoryImpl(DataSource dataSource) {

    this.insertRole =
        new SimpleJdbcInsert(dataSource).withTableName("Roles").usingGeneratedKeyColumns("RoleId");

    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

  }


  @Override
  public Role findById(Long roleId) throws DataAccessException {
    Map<String, Object> params = new HashMap<>();
    params.put("roleId", roleId);
    List<Role> roles = this.namedParameterJdbcTemplate.query(
        "SELECT RoleId, Name FROM Roles WHERE RoleId = :roleId", params,
        BeanPropertyRowMapper.newInstance(Role.class));
    return roles.get(0);
  }


}
