package dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tools.ConfigLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDaoImpl implements TestDao {
    ConfigLoader configLoader = new ConfigLoader();

    private static Connection connection;
    private static Statement statement;

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Test findById(int id) throws SQLException {
        String QUERY_FIND_ID = "SELECT * FROM test WHERE id =" + id;
        connection();
        Test test = new Test();
        try {
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ID);

            resultSet.next();
            test.setId(resultSet.getString("id"));
            test.setName(resultSet.getString("name"));

        } catch (Exception e) {
            logger.debug(e);
        }
        return test;
    }

    @Override
    public void setData(int id, String name) throws SQLException {
        String sql = "INSERT INTO test(id, name) value (?, ?);";
        connection();
        try (final PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.debug(e);
        }
    }

    @Override
    public List<Test> findAll()   {
        String QUERY_FIND_ALL = "SELECT * FROM test";
        List<Test> listTest = new ArrayList();
        connection();

        try {
            ResultSet resultSet = statement.executeQuery(QUERY_FIND_ALL);

            while (resultSet.next()) {
                Test test = new Test();
                test.setId(resultSet.getString("id"));
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
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/DataBaseTest", "user", "user");
            statement = connection.createStatement();
        } catch (Exception e) {
            logger.debug(e);
        }
    }
}