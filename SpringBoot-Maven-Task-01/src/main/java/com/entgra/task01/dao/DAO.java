package com.entgra.task01.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> getAll();

    Optional<T> get(int id);

    boolean save(T t);

    boolean update(T t);

    boolean delete(int id);
}
