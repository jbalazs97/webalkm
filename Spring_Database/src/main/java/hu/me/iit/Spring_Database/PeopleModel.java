package hu.me.iit.Spring_Database;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Min;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class PeopleModel {
    @Id
    @Generated
    private Long id;

    private String name;

    @Min(12)
    private int age;

    public PeopleModel(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public PeopleModel() {

    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PeopleModel toPeople(){
        return new PeopleModel(null,name, age);
    }
}