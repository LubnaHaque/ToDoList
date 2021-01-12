package com.dsi.ToDoList.model;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_generator")
    @SequenceGenerator(name = "task_generator", sequenceName = "task_seq")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 1 , max = 200)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
