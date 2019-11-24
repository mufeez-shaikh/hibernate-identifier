package com.company.jpaidentifier.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "account")
public class Account {

    @Id
    @TableGenerator(name = "account_seq_table_generator",
            table = "user_ids",
            pkColumnName = "seq_id",
            valueColumnName = "seq_value",
            allocationSize = 2)
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "account_seq_table_generator"
    )
    private Long userId;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    @Column
    private Date createdOn;
    @Column
    private Date lastLogin;
}
