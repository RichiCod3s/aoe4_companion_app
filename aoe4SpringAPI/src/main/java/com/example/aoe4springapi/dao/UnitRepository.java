package com.example.aoe4springapi.dao;

import com.example.aoe4springapi.api.model.ConcreteUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class UnitRepository implements DAO<ConcreteUnit>{

    private static final Logger log = LoggerFactory.getLogger(UnitRepository.class);

    private JdbcTemplate jdbcTemplate;

    RowMapper<ConcreteUnit> rowMapper = (rs, rowNum) ->
            new ConcreteUnit(
                    rs.getInt("id"),
                    rs.getString("unit_name"),
                    rs.getString("unit_type"),
                    rs.getString("armour_type"),
                    rs.getString("attack_type")
            );


    public UnitRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ConcreteUnit> list() {
        String sql = "SELECT * FROM units";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(ConcreteUnit concreteUnit) {
        String sql = "INSERT INTO units (unit_name, unit_type, armour_type, attack_type) VALUES (?, ?, ?, ?)";
       int insert = jdbcTemplate.update(sql,
                concreteUnit.getUnitName(),
                concreteUnit.getUnitType(),
                concreteUnit.getArmourType(),
                concreteUnit.getAttackType());
        if(insert ==1){
            log.info("new concrete unit created{}", concreteUnit.getUnitName());
        }
    }

    @Override
    public Optional<ConcreteUnit> get(int id) {
        String sql = "SELECT * FROM units WHERE id = ?";
        try {
            ConcreteUnit unit = jdbcTemplate.queryForObject(sql, rowMapper, id);
            return Optional.ofNullable(unit);
        } catch (DataAccessException e) {
            log.info("Unable to get concrete unit with id {}", id);
            return Optional.empty();
        }
    }

    @Override
    public void update(ConcreteUnit concreteUnit, int id) {
        String sql = "UPDATE units SET unit_name = ?, unit_type = ?, armour_type = ?, attack_type = ? WHERE id = ?";
        int update = jdbcTemplate.update(sql,
                concreteUnit.getUnitName(),
                concreteUnit.getUnitType(),
                concreteUnit.getArmourType(),
                concreteUnit.getAttackType(),
                id);
        if(update ==1){
            log.info("Unit updated: {}", concreteUnit.getUnitName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM units WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
