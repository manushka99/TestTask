package dao;

import java.sql.SQLException;
import java.util.List;

public interface TestDao {

    Test findById(int id) throws SQLException;

    List<Test> findAll();

    void setData(int id, String name) throws SQLException;

}
