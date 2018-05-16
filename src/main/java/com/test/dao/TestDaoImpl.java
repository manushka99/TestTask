package com.test.dao;

import com.test.model.Test;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {

    final static Logger logger = Logger.getLogger(TestDaoImpl.class);
    private static Connection connection;
    private static Statement statement;

    private String url ="jdbc:mysql://localhost:3306/DataBaseTest";
    private String userLogin = "user";
    private String userPasswd = "user";

    @Override
    public Test findById(long id) {
        String QUERY_FIND_ID = "SELECT * FROM test_task WHERE id =" + id;
        connection();
        Test test = new Test();
        try {
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ID);

            resultSet.next();
            test.setId(resultSet.getLong("id"));
            test.setName(resultSet.getString("name"));
        } catch (Exception e) {
            logger.debug(e);
        }
        return test;
    }

    @Override
    public void setData(long id, String name) {
        String QUERY_SET_DATA = "INSERT INTO test_task(id, name) value (?, ?);";
        connection();
        try (final PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_DATA)) {

            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.debug(e);
        }
    }

    @Override
    public List<Test> findAll() {
        String QUERY_FIND_ALL = "SELECT * FROM test_task";
        List<Test> listTest = new ArrayList();
        connection();

        try {
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ALL);

            while (resultSet.next()) {
                Test test = new Test();
                test.setId(resultSet.getLong("id"));
                test.setName(resultSet.getString("name"));
                listTest.add(test);
            }

        } catch (Exception e) {
            logger.debug(e);
        }
        return listTest;
    }

    private void connection() {
        try {
            connection = DriverManager.getConnection(url, userLogin, userPasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            logger.debug(e);
        }
    }
}