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

    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;


    @ManyToOne
    @JoinColumn(name = "statementId")
    private StatementEntity statementEntity;

}
