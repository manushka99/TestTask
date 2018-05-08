import org.junit.Test;
import service.TestTaskServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTaskService {


    @Test
    public void findAllTest() {
        TestTaskServiceImpl testTaskService = new TestTaskServiceImpl();

        assertNull(testTaskService.findAll());
    }

    @Test
    public void findById() {
        TestTaskServiceImpl testTaskService = new TestTaskServiceImpl();
            String result = testTaskService.findById(1);
        assertEquals(result, "1 test-1");
    }

}
