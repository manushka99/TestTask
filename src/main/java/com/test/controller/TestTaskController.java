package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.service.TestTaskService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TestTaskController {

    @Autowired
    TestTaskService testTaskService;

    String test;

    @RequestMapping(value = "/findAll", method = GET)
    public String findAll() {
        return testTaskService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", method = GET)
    public String findById(@PathVariable long id) {
        return testTaskService.findById(id);
    }

    @RequestMapping(value = "/setData/{id}/{name}", method = POST)
    public String setData(@PathVariable long id, @PathVariable String name) {
        return testTaskService.setData(id, name);

    }
}

