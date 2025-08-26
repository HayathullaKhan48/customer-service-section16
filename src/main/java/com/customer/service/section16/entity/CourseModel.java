package com.customer.service.section16.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "instructor")
    private String instructor;

    @ManyToMany(mappedBy = "courses")
    private Set<StudentModel> students = new HashSet<>();
}
