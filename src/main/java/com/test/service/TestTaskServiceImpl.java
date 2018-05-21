package com.test.service;

import com.test.dao.TestDao;
import com.test.dto.DataDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTaskServiceImpl implements TestTaskService {
    final static Logger logger = Logger.getLogger(TestTaskServiceImpl.class);

    @Autowired
    TestDao testDao;

    @Override
    public List<DataDto> findAll() {
        try {

            return testDao.findAll();
        } catch (Exception e) {
            logger.info(e);
            return null;
        }
    }

    @Override
    public Object setData(DataDto dataDto) {
        try {

            return testDao.setData(dataDto);
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

