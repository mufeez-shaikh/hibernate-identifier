package com.mufizco.hibernateapp.entities;

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

    private String username;

    private String password;

    private String email;

    private Date createdOn;

    private Date lastLogin;
}
