package com.test.service;

import com.test.dao.TestDao;
import com.test.dto.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TestTaskServiceImpl implements TestTaskService {

    private final TestDao testDao;

    @Autowired
    public TestTaskServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public List<DataDto> findAll() {
        try {

            return testDao.findAll();
        } catch (Exception e) {
            log.debug("findAll", e);
            return null;
        }
    }

    @Override
    public Object setData(DataDto dataDto) {
        try {
            return testDao.setData(dataDto);
        } catch (Exception e) {
            log.debug("findAll", e);
            return null;
        }
    }

    @Override
    public Object findById(long id) {
        try {
            return testDao.findById(id);

        } catch (Exception e)   {
            log.debug("findById", e);
            return null;
        }
    }
}

