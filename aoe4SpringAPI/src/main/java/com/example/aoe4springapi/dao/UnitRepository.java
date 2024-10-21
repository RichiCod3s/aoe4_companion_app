package com.example.aoe4springapi.dao;

import com.example.aoe4springapi.api.model.ConcreteUnit;
import com.example.aoe4springapi.api.model.EnemyUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public class UnitRepository implements DAO<ConcreteUnit>{

    private static final Logger log = LoggerFactory.getLogger(UnitRepository.class);

    private JdbcTemplate jdbcTemplate;

    public UnitRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<ConcreteUnit> rowMapper = (rs, rowNum) ->
            new ConcreteUnit(
                    rs.getInt("id"),
                    rs.getString("unit_name"),
                    rs.getString("unit_type"),
                    rs.getString("armour_type"),
                    rs.getString("attack_type")
            );


    RowMapper<EnemyUnit> enemyRowMapper = (rs, rowNum) ->
            new EnemyUnit(
                    rs.getInt("id"),
                    rs.getString("unit_name"),
                    rs.getString("unit_type"),
                    rs.getString("armour_type"),
                    rs.getString("attack_type")
            );

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

    public List<EnemyUnit> retrieveStrongAgainst(int unitId) {
        String sql = "SELECT enemy_units.id, enemy_units.unit_name, enemy_units.unit_type, " +
                "enemy_units.armour_type, enemy_units.attack_type " +
                "FROM units " +
                "JOIN strong_against ON units.id = strong_against.unit_id " +
                "JOIN units AS enemy_units ON enemy_units.id = strong_against.enemy_id " +
                "WHERE units.id = ?";
        return jdbcTemplate.query(sql, enemyRowMapper, unitId);
    }

    public List<EnemyUnit> retrieveWeakAgainst(int unitId) {
        String sql = "SELECT enemy_units.id, enemy_units.unit_name, enemy_units.unit_type, " +
                "enemy_units.armour_type, enemy_units.attack_type " +
                "FROM units " +
                "JOIN weak_against ON units.id = weak_against.unit_id " +
                "JOIN units AS enemy_units ON enemy_units.id = weak_against.enemy_id " +
                "WHERE units.id = ?";
        return jdbcTemplate.query(sql, enemyRowMapper, unitId);
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
        if(update == 1){
            log.info("Unit updated: {}", concreteUnit.getUnitName());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM units WHERE id = ?";
       int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected > 0) {
            log.info("Deleted unit with id: {}", id);
        }
    }

}
