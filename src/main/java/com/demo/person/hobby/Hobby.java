package com.demo.person.hobby;

import jakarta.persistence.*;

// For Hibernate
@Entity
// For table in database
@Table
public class Hobby {
    @Id
    @SequenceGenerator(
            name="hobbies_sequence",
            sequenceName="hobbies_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hobbies_sequence"
    )
    long id;
    String name;

    public Hobby(String name) {
        this.name = name;
    }

    public Hobby() {

    }

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

    @Override
    public String toString() {
        return "Hobbies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public String IdToString() {
        return Long.toString(id);
    }
}
