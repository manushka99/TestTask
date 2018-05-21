package com.test.dao;

import com.test.dto.SetDataDto;
import com.test.model.Test;

import java.sql.SQLException;
import java.util.List;

public interface TestDao {

    Test findById(long id) throws SQLException;

    List<Test> findAll();

    boolean setData(SetDataDto setDataDto);

}
