package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Employee
 */
@Entity
class Employee {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String role;

    Employee(){}
    Employee(String firstName, String lastName, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return firstName + " " + lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getRole() {
        return role;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        String[] pair = name.split(" ");
        this.firstName = pair[0];
        this.lastName = pair[1];
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return Objects.equals(this.id, employee.id) && 
            Objects.equals(this.firstName, employee.firstName) && 
            Objects.equals(this.lastName, employee.lastName) &&
            Objects.equals(this.role, employee.role);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName,this.lastName, this.role);
    }
    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + 
            ", firstName='" + this.firstName + '\'' + 
            ", lastName='" + this.lastName + '\'' +
            ", role='" + this.role + '\'' + '}';
    }
}
