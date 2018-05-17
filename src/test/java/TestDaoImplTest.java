import com.test.Application;
import com.test.dao.TestDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.sql.SQLException;

import static org.junit.Assert.*;


@SpringApplicationConfiguration(Application.class)
public class TestDaoImplTest {

    @Autowired
    private TestDao testDao;

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
