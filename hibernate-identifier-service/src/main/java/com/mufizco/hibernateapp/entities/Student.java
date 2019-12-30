package com.mufizco.hibernateapp.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ_GENERATOR")
    @SequenceGenerator(name = "STUDENT_SEQ_GENERATOR", sequenceName = "STUDENT_SEQ", allocationSize = 1)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(mappedBy = "student")
    private List<Address> address;

    @Column
    private String email;

    @Column
    private Date createdOn = new Date();

    @Column
    private Date lastUpdated = new Date();
}
