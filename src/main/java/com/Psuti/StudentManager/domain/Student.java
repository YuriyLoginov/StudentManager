package com.Psuti.StudentManager.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String patronymic;

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date dateOfBirth;

    private String course;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private StudentGroup student;

    private String login;

    private String password;

}
