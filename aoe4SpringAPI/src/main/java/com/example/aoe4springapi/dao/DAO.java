package com.example.aoe4springapi.dao;

import com.example.aoe4springapi.api.model.ConcreteUnit;

import javax.swing.tree.RowMapper;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> list();

    void create(T t);

    Optional<T> get(int id);

    void update(T t, int id);

    void delete(int id);
}
