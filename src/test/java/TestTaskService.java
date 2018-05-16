import org.apache.log4j.Logger;
import org.junit.Test;
import com.test.service.TestTaskServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTaskService {

    @Test
    public void findAllTest() {
        TestTaskServiceImpl testTaskService = new TestTaskServiceImpl();
        assertNull(testTaskService.findAll());
    }
}