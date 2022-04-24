package com.quesito.struts.repository;


import com.quesito.struts.model.Person;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PersonRepositoryImpl implements PersonRepository {
    @Inject
    private NamedParameterJdbcOperations jdbcTemplate;

    @Override
    public List<Person> getPeople() {
        String query = "SELECT * FROM persons";
        return jdbcTemplate.query(query, (rs, rowNum) -> mapRowToProduct(rs));
    }

    @Override
    public void createPerson(Person person) {
        String sql = " INSERT INTO persons(name, age) VALUES (:name, :age) ";
        Map<String, Object> params = new HashMap<>();
        params.put("name", person.getName());
        params.put("age", person.getAge());
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void update(Person person) {
        String sql = " UPDATE persons SET name = :name,age = :age  WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", person.getId());
        params.put("name",person.getName());
        params.put("age",person.getAge());
        jdbcTemplate.update(sql,params);
    }

    @Override
    public void deletePerson(Integer id) {
        String sql = " DELETE FROM persons WHERE id = :id ";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbcTemplate.update(sql,params);
    }

    @Override
    public Person getPersonById(Integer id) {
        String query = "SELECT * FROM persons WHERE ID = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(query, params, (rs, rowNum) -> mapRowToProduct(rs));
    }

    public Person mapRowToProduct(ResultSet rs) throws SQLException {
        return Person.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .age(rs.getInt("age"))
                .build();

    }
}
