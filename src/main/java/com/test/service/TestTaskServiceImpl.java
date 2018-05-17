package com.test.service;

import java.sql.SQLException;
import java.util.List;

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
    public String findAll() {
        try {
            TestDaoImpl testDao = new TestDaoImpl();

            List<Test> listTest = testDao.findAll();
            String listResult = "";
            for (int i = 0; i < listTest.size(); i++) {
                listResult = listResult + " " + listTest.get(i).getName();
            }
            return listResult;
        } catch (Exception e) {
            logger.info(e);
            return null;
        }
    }

    @Override
    public String setData(long id, String name) {
//        try {
//            if (!checkExistingId(id)) {
//                testDao.setData(id, name);
//                return "yes";
//            } else {
//                return "id exist";
//            }
//        } catch (Exception e) {
//            logger.info(e);
//            return null;
//        }
        return "ReturnSpringBoot";
    }

    @Override
    public String findById(long id) {
        try {
            Test test = testDao.findById(id);
            String result =  test.getId() + " " + test.getName();
            return result;

        } catch (Exception e)   {
            logger.info(e);
            return null;
        }
    }

    private boolean checkExistingId(long id) throws SQLException {
        Test test = testDao.findById(id);
        if(id == test.getId()) {
            return true;
        }
        return false;
    }
}

