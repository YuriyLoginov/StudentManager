package com.Psuti.StudentManager.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacherEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectEntity")
    private List<StatementEntity> statementEntities;

}
