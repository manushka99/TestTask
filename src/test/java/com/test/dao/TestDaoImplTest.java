package com.test.dao;

import com.test.dto.DataDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestDaoImpl.class)
public class TestDaoImplTest {

    @Autowired
    TestDao testDao;

    @Test
    public void findById() {
        assertEquals("UnitTestName", testDao.findById(-1L).getName());
    }

    @Test
    public void setData() {
        DataDto dataDto = new DataDto().builder()
                .id(-3L)
                .name("TestDTO")
                .build();
        testDao.setData(dataDto);
    }

    @Test
    public void findAll() {
        assertNotNull(testDao.findAll());
    }
}