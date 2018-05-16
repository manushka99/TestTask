import org.apache.log4j.Logger;
import org.junit.Test;
import com.test.service.TestTaskServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTaskService {

    final static Logger logger = Logger.getLogger(TestTaskService.class);
    @Test
    public void findAllTest() {
        TestTaskServiceImpl testTaskService = new TestTaskServiceImpl();

        assertNull(testTaskService.findAll());
    }

    @Test
    public void findById() {
       try {
           throw new Exception();
       } catch (Exception e) {
           logger.info(e);
       }
    }

}
