import com.test.Application;
import com.test.dao.TestDao;
import com.test.dao.TestDaoImpl;
import com.test.dto.SetDataDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.sql.SQLException;

import static org.junit.Assert.*;


@SpringApplicationConfiguration(Application.class)
public class TestDaoImplTest {

   TestDaoImpl testDao = new TestDaoImpl();


    @Test
    public void findByIdTest() throws SQLException {
        assertEquals("UnitTestName", testDao.findById(-1L).getName());
    }

    @Test
    public void setDataTest() {
        SetDataDto setDataDto = new SetDataDto().builder()
                .id(-3)
                .name("TestDTO")
                .build();
        testDao.setData(setDataDto);

        assertEquals("TestDTO", testDao.findById(-3).getName());
    }

    @Test
    public void findAllTest() {
            assertNotNull(testDao.findAll());
    }
}
