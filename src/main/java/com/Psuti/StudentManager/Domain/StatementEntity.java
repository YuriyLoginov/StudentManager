package com.Psuti.StudentManager.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Statement")
public class StatementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private SubjectEntity subjectEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statementEntity")
    private List<StatinfEntity> statinfEntities;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private StudentGroupEntity studentGroupEntity;

}