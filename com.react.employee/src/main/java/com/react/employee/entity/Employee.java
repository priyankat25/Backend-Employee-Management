package com.react.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int salary;

    @Column(columnDefinition = "json")
    private String assets; // Store as JSON

    public Employee() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Getters and setters for assets
    public List<String> getAssets() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, String.class);
            return mapper.readValue(this.assets, listType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null; // Handle this appropriately
        }
    }

    public void setAssets(List<String> assets) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.assets = mapper.writeValueAsString(assets);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            this.assets = "[]"; // Default to empty JSON array
        }
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", assets=" + getAssets() + "]";
    }
}