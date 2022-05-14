package com.Psuti.StudentManager.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String faculty;

    private String direction;

    private String Name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Student> studentList;

    private String statement;
}