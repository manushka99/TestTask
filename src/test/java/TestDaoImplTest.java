import dao.TestDaoImpl;
import org.junit.Test;


import java.sql.SQLException;

import static org.junit.Assert.*;

public class TestDaoImplTest {

    @Test
    public void findByIdTest() throws SQLException {
        TestDaoImpl testDaoImpl = new TestDaoImpl();
            testDaoImpl.findById(11);
            String id = testDaoImpl.findById(1).getId();
            String name = testDaoImpl.findById(1).getName();
            assertEquals("1", id);
            assertEquals("test", name);
    }

    @Test
    public void setDataTest() throws SQLException {
        TestDaoImpl testDaoImpl = new TestDaoImpl();
        testDaoImpl.setData(1,"unitTest");

    }

    @Test
    public void findAllTest() {
        TestDaoImpl testDaoImpl = new TestDaoImpl();
            assertNull(testDaoImpl.findAll());
    }
}
