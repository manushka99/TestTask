package com.test.service;

public interface TestTaskService {
    String findAll();

    String setData(int id, String name);

    String findById(int id);
}
