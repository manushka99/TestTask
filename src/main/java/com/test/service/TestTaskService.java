package com.test.service;

import com.test.dto.SetDataDto;
import com.test.model.Test;

import java.util.List;

public interface TestTaskService {
    List<Test> findAll();

    Object setData(SetDataDto setDataDto);

    Object findById(long id);
}
