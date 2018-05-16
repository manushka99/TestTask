package com.test.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Test {
    @Getter
    @Setter
    long id;

    @Getter
    @Setter
    private String name;
}
