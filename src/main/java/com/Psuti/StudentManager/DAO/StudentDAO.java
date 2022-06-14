package com.Psuti.StudentManager.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentDAO {

    private Long id;
    private String course;
    private String dateOfBirth;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String groupId;
    private String login;
    private String password;
    private String role;
}
