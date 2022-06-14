package com.Psuti.StudentManager.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "StudentGroup")
public class StudentGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String faculty;

    private String direction;

    private String Name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentGroup")
    private List<StudentEntity> studentEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentGroupEntity")
    private List<StatementEntity> statementEntities;

}