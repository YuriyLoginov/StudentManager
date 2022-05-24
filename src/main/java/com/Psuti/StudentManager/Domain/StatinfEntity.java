package com.Psuti.StudentManager.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
