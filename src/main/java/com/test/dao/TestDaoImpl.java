package com.test.dao;

import com.test.dto.SetDataDto;
import com.test.model.Test;
import com.test.tools.ConfigLoader;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TestDaoImpl implements TestDao {
    ConfigLoader configLoader = new ConfigLoader();

    final static Logger logger = Logger.getLogger(TestDaoImpl.class);
    private static Connection connection;
    private static Statement statement;

    private String url = configLoader.getUrl();
    private String userLogin = configLoader.getUserName();
    private String userPasswd = configLoader.getUserPasswd();

    private final String QUERY_FIND_ID = "SELECT * FROM test_task WHERE id =";
    private final String QUERY_SET_DATA = "INSERT INTO test_task(id, name) value (?, ?);";
    private final String QUERY_FIND_ALL = "SELECT * FROM test_task";

    @Override
    public Test findById(long id) {
        connection();
        Test test = new Test();
        try {
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ID + id);

            resultSet.next();
            test.setId(resultSet.getLong("id"));
            test.setName(resultSet.getString("name"));
        } catch (Exception e) {
            logger.debug(e);
        }
        return test;
    }

    @Override
    public boolean setData(SetDataDto setDataDto) {
        connection();
        try (final PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_DATA)) {

            preparedStatement.setLong(1, setDataDto.getId());
            preparedStatement.setString(2, setDataDto.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            logger.debug(e);
            return false;
        }
    }

    @Override
    public List<Test> findAll() {
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