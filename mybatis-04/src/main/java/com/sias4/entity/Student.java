package com.sias4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edgar
 * @create 2022-03-31 14:30
 * @faction:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private Teacher teacher;
}
