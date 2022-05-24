package com.Psuti.StudentManager.Domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Student")
public class StudentEntity {

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
    private StudentGroupEntity student;

    @ManyToOne
    @JoinColumn(name = "statinf_id")
    private StatinfEntity statinfEntity;

    private String login;

    private String password;

}
