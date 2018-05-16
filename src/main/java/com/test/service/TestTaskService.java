package com.test.service;

public interface TestTaskService {
    String findAll();

    String setData(long id, String name);

    String findById(long id);
}
