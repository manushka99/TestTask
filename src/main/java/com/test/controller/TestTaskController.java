package com.test.controller;

import com.test.dto.SetDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.service.TestTaskService;

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
    public Object setData(@RequestBody SetDataDto setDataDto) {
        return testTaskService.setData(setDataDto);

    }
}

