package com.test.dao;

import com.test.dto.DataDto;
import com.test.model.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ComponentScan(value = "com.test.*")
@PropertySource("classpath:values.properties")
@Repository
public class TestDaoImpl implements TestDao {

    private static Connection connection;
    private static Statement statement;

    @Value("${value.url}")
    private String url;

    @Value("${value.user.name}")
    private String userLogin;

    @Value("${value.user.password}")
    private String userPasswd;

    private final String QUERY_FIND_ID = "SELECT * FROM test_task WHERE id =";
    private final String QUERY_SET_DATA = "INSERT INTO test_task(id, name) VALUE (?, ?);";
    private final String QUERY_FIND_ALL = "SELECT * FROM test_task";


    @Override
    public DataDto findById(long id) {
        connection();
        Test test = new Test();
        try {
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ID + id);
            resultSet.next();
            test.setId(resultSet.getLong("id"));
            test.setName(resultSet.getString("name"));
        } catch (Exception e) {
            log.debug("findById", e);
        }

        return new DataDto().builder()
                .id(test.getId())
                .name(test.getName())
                .build();
    }

    @Override
    public boolean setData(DataDto dataDto) {
        connection();
        try (final PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_DATA)) {

            preparedStatement.setLong(1, dataDto.getId());
            preparedStatement.setString(2, dataDto.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            log.debug("setData", e);
            return false;
        }
    }

    @Override
    public List<DataDto> findAll() {
        List<DataDto> listTest = new ArrayList();
        connection();

        try {
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ALL);

            while (resultSet.next()) {
                Test test = new Test();
                test.setId(resultSet.getLong("id"));
                test.setName(resultSet.getString("name"));
                listTest.add(new DataDto().builder()
                              .id(test.getId())
                              .name(test.getName())
                              .build());
            }

        } catch (Exception e) {
            log.debug("findAll", e);
        }
        return listTest;
    }

    private void connection() {
        try {
            connection = DriverManager.getConnection(url, userLogin, userPasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            log.debug("connection", e);
        }
    }
}