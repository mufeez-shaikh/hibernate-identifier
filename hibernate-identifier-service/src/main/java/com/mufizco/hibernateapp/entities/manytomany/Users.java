package com.mufizco.hibernateapp.entities.manytomany;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@ToString
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_GENERATOR")
    @SequenceGenerator(name = "USERS_SEQ_GENERATOR", sequenceName = "USERS_SEQ", allocationSize = 1)
    private Long id;

    @Column
    private String userName;

    @ManyToMany
    @JoinTable(name = "USER_LISTING",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "listing_id")}
    )
    private Set<Listing> listings;

    @Column
    @Builder.Default
    private Date createdOn = new Date();

    @Column
    @Builder.Default
    private Date lastUpdated = new Date();
}
