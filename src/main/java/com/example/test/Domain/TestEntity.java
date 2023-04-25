package com.example.test.Domain;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "Tests")
public class TestEntity {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
    @Column
    @NonNull
    public String Name;

    public TestEntity() {
    }

    public TestEntity(int id, String name) {
        Id = id;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
