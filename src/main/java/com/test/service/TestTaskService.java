package com.test.service;

import com.test.dto.DataDto;

import java.util.List;

public interface TestTaskService {
    List<DataDto> findAll();

    Object setData(DataDto dataDto);

    Object findById(long id);
}
