package com.test.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dto.SetDataDto;
import com.test.model.Test;
import com.test.dao.TestDao;
import com.test.dao.TestDaoImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTaskServiceImpl implements TestTaskService {
    final static Logger logger = Logger.getLogger(TestTaskServiceImpl.class);

    @Autowired
    TestDao testDao;

    @Override
    public List<Test> findAll() {
        try {

            return testDao.findAll();
        } catch (Exception e) {
            logger.info(e);
            return null;
        }
    }

    @Override
    public Object setData(SetDataDto setDataDto) {
        try {

            return testDao.setData(setDataDto);
        } catch (Exception e) {
            logger.info(e);
            return null;
        }
    }

    @Override
    public Object findById(long id) {
        try {
            return testDao.findById(id);

        } catch (Exception e)   {
            logger.info(e);
            return null;
        }
    }
}

