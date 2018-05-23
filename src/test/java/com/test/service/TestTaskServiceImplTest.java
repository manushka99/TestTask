package com.test.service;

import com.test.dto.DataDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestTaskServiceImpl.class)
public class TestTaskServiceImplTest {

    @Autowired
    TestTaskService testTaskService;

    @Test
    public void findAll() {
        assertNotNull(testTaskService.findAll());
    }

    @Test
    public void setData() {
        DataDto dataDto = new DataDto().builder()
                .id(-3L)
                .name("TestDTO")
                .build();
        testTaskService.setData(dataDto);
        assertNotNull(testTaskService.findById(-3L));
    }

    @Test
    public void findById() {
        assertEquals( "-1", testTaskService.findById(-1L));
    }
}