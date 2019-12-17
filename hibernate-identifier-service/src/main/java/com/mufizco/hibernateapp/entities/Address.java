package com.mufizco.hibernateapp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ_GENERATOR")
    @SequenceGenerator(name = "ADDRESS_SEQ_GENERATOR", sequenceName = "ADDRESS__SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @Column
    private String street;

    @Column
    private String unitNo;

    @Column
    private int zip;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private Date createdOn = new Date();

    @Column
    private Date lastUpdated = new Date();


}
