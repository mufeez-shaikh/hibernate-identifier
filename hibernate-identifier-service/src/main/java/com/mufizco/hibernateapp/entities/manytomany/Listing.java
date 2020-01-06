package com.mufizco.hibernateapp.entities.manytomany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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

    @JsonIgnore
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "listings")
    @JsonIgnoreProperties("listings")
    private Set<Users> users = new HashSet<>();

    @Column
    @Builder.Default
    private Date createdOn = new Date();

    @Column
    @Builder.Default
    private Date lastUpdated = new Date();

    public void addUsers(Users users) {
        this.users.add(users);
    }
}
