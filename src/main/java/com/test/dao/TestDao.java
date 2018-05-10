package com.test.dao;

import com.test.model.Test;

import java.sql.SQLException;
import java.util.List;

public interface TestDao {

    Test findById(int id) throws SQLException;

    List<Test> findAll();

    void setData(int id, String name) throws SQLException;

}