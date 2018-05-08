package service;

import java.util.List;

import dao.Test;
import dao.TestDao;
import dao.TestDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class TestTaskServiceImpl implements TestTaskService {

    @Override
    public String findAll() {
        TestDaoImpl testDao = new TestDaoImpl();
        List<Test> listTest = testDao.findAll();
        String listResult = "";
        for (int i = 0; i < listTest.size(); i++) {
            listResult = listResult + " " + listTest.get(i).getName();
        }
        return listResult;
    }

    @Override
    public String setData(int id, String name) {
        TestDaoImpl testDao = new TestDaoImpl();
        try {
            testDao.setData(id, name);
            return "yes";
        } catch (Exception e) {
            return "no";
        }
    }

    @Override
    public String findById(int id) {
        TestDaoImpl testDao = new TestDaoImpl();
        try {
            Test test = testDao.findById(id);
            String result =  test.getId() + " " + test.getName();
            return result;
        } catch (Exception e)   {
            return null;
        }

    }
}
