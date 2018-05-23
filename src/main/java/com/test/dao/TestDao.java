package com.test.dao;

import com.test.dto.DataDto;

import java.util.List;

public interface TestDao {

    DataDto findById(long id);

    List<DataDto> findAll();

    boolean setData(DataDto dataDto);

}
