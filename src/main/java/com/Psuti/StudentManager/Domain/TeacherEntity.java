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
@Table(name = "Teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String firstName;

    private String lastName;

    private String Patronymic;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherEntity")
    private List<SubjectEntity> subjectEntityList;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
