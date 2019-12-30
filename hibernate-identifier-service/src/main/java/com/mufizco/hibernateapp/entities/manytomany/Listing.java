package com.mufizco.hibernateapp.entities.manytomany;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LISTING_SEQ_GENERATOR")
    @SequenceGenerator(name = "LISTING_SEQ_GENERATOR", sequenceName = "LISTING_SEQ", allocationSize = 1)
    private Long id;

    @Column
    private String itemName;

    @ManyToMany (mappedBy = "listings")
    private Set<Users> users;

    @Column
    @Builder.Default
    private Date createdOn = new Date();

    @Column
    @Builder.Default
    private Date lastUpdated = new Date();
}
