import com.test.dao.TestDao;
import com.test.dao.TestDaoImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.SQLException;

import static org.junit.Assert.*;


public class TestDaoImplTest {

    TestDaoImpl testDao = new TestDaoImpl();

    @Test
    public void findByIdTest() throws SQLException {
        testDao.setData(-1, "UnitTestName");
            assertEquals("UnitTestName", testDao.findById(-1L).getName());
    }

    @Test
    public void setDataTest() throws SQLException {
        testDao.setData(-1, "UnitTestName");
        assertEquals("UnitTestName", testDao.findById(-1).getName());
    }

    @Test
    public void findAllTest() {
            assertNotNull(testDao.findAll());
    }
}
