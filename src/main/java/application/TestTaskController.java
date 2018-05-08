package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TestTaskService;
import service.TestTaskServiceImpl;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TestTaskController {

    @RequestMapping(value = "/findAll", method = GET)
    public String findAll() {
        TestTaskServiceImpl testTaskService = new TestTaskServiceImpl();
        return testTaskService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", method = GET)
    public String findById(@PathVariable int id) {
        TestTaskServiceImpl testTaskService = new TestTaskServiceImpl();
        return testTaskService.findById(id);
    }

    @RequestMapping(value = "/setData/{id}/{name}", method = POST)
    public String setData(@PathVariable int id, @PathVariable String name) {
        TestTaskServiceImpl testTaskService = new TestTaskServiceImpl();
        return testTaskService.setData(id, name);

    }
}

