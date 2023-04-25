package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "course_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gan",sequenceName = "course_seq",allocationSize = 1)
    private Long id;
    private String name;
    private int price;

    public Course(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
