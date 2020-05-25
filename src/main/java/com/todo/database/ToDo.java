package com.todo.database;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;
    public String title;
    public String description;
    public String status;
}
