package com.example.payroll_maven;

import java.util.Objects;

// persistence error solved with this answer: https://stackoverflow.com/a/76794282

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
    private @Id @GeneratedValue Long id;
//    private String name;
    private String firstName;
    private String lastName;
    private String role;

    Employee() {}

    Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.name = name;
        this.role = role;
    }

    public String getName()
    {
        return this.firstName.trim() + " " + this.lastName.trim();
    }

    public void setName(String name){
        String[] parts = name.split(" ");
        this.firstName = parts[0].trim();
        this.lastName = parts[1].trim();
    }

//        public void setName(String name) {
//        this.name = name;
//    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName.strip();
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName.strip();
    }

    public String getRole()
    {
        return this.role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.firstName, employee.firstName)
                && Objects.equals(this.lastName, employee.lastName) &&Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName,this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", firstName='" + this.firstName.strip() + '\'' + ", lastName='" + this.lastName.strip()+ '\''  +", role='" + this.role + '\'' + '}';
    }

}
