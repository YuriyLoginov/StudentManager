package com.Psuti.StudentManager.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Statement")
public class StatementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Date date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statementEntity")
    private List<SubjectEntity> subjectEntityList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statementEntity")
    private List<StatinfEntity> statinfEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statementEntity")
    private List<StudentGroupEntity> studentGroupEntities;

}