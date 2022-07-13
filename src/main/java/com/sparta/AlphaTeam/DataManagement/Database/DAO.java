package com.sparta.AlphaTeam.DataManagement.Database;

import com.sparta.AlphaTeam.DataManagement.Employee;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(int id);
    List<T> getAll();
    void add(T t);
}
