package com.test.dao;

import com.test.dto.DataDto;

import java.sql.SQLException;
import java.util.List;

public interface TestDao {

    DataDto findById(long id) throws SQLException;

    List<DataDto> findAll();

    boolean setData(DataDto dataDto);

}
