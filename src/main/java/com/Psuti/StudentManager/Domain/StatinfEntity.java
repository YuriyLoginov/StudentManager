package com.Psuti.StudentManager.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Statinf")
public class StatinfEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long grade;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statinfEntity")
    private List<StudentEntity> studentEntities;

    @ManyToOne
    @JoinColumn(name = "statement_id")
    private StatementEntity statementEntity;

}
