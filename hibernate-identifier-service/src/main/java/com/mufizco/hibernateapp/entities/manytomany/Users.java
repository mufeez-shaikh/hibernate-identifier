package com.mufizco.hibernateapp.entities.manytomany;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "USER_LISTING",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "listing_id")}
    )
    @Builder.Default
    @JsonIgnoreProperties("users")
    private Set<Listing> listings = new HashSet<>();

    @Column
    @Builder.Default
    private Date createdOn = new Date();

    @Column
    @Builder.Default
    private Date lastUpdated = new Date();

    public void addListing(Listing listing){
        this.listings.add(listing);
    }
}
