package com.Psuti.StudentManager.Domain;

import com.Psuti.StudentManager.Domain.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    private String dateOfBirth;

    private String course;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private StudentGroupEntity studentGroup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEntity")
    private List<StatinfEntity> statinfEntities;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
