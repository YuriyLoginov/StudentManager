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