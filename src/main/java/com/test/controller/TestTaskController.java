package com.test.controller;

import com.test.dto.DataDto;
import com.test.service.TestTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TestTaskController {

    @Autowired
    TestTaskService testTaskService;

    @RequestMapping(value = "/findAll", method = GET)
    public Object findAll() {
        return testTaskService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", method = GET)
    public Object findById(@PathVariable long id) {
        return testTaskService.findById(id);
    }

    @RequestMapping(value = "/setData", method = POST)
    public Object setData(@RequestBody DataDto dataDto) {
        return testTaskService.setData(dataDto);

    }
}

