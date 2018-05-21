import com.test.Application;
import com.test.dao.TestDaoImpl;
import com.test.dto.DataDto;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@SpringApplicationConfiguration(Application.class)
public class TestDaoImplTest {

   TestDaoImpl testDao = new TestDaoImpl();


    @Test
    public void findByIdTest() throws SQLException {
        assertEquals("UnitTestName", testDao.findById(-1L).getName());
    }

    @Test
    public void setDataTest() {
        DataDto dataDto = new DataDto().builder()
                .id(-3)
                .name("TestDTO")
                .build();
        testDao.setData(dataDto);

        assertEquals("TestDTO", testDao.findById(-3).getName());
    }

    @Test
    public void findAllTest() {
            assertNotNull(testDao.findAll());
    }
}
