package com.poc.entities.core;

import com.poc.constants.SequenceGenConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "D002001")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class D002001 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SequenceGenConstants.D002001_SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SequenceGenConstants.D002001_SEQUENCE_GENERATOR,
            sequenceName = SequenceGenConstants.D002001_SEQUENCE_GENERATOR,
            allocationSize = SequenceGenConstants.D002001_SEQ_ALLOCATION_SIZE)
    @Column(name = "id",nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1,max = 50)
    @Column(name = "username",unique = true,nullable = false,length = 50)
    private String username;

    @NotNull
    @Size(min = 8,max = 100)
    @Column(name = "password_hash",nullable = false,length = 100)
    private String passwordHash;

    @Size(max = 100)
    @Column(name = "first_name",length = 100)
    private String firstName;

    @Size(max = 100)
    @Column(name = "middle_name",length = 100)
    private String middleName;

    @Size(max = 100)
    @Column(name = "last_name",length = 100)
    private String lastName;

    @Size(min = 10,max = 254)
    @Email
    @Column(name = "email",length = 254,unique = true)
    private String email;

    @Size(min = 1,max = 1)
    @Column(name = "gender_id",length = 1)
    private int genderId;

    @Column(name = "date_of_birth")
    private Instant dob;

    @Size(max = 256)
    @Column(name = "image_url",length = 256)
    private String imageUrl;

    @Column(name = "lang_key")
    private String langKey;

    @Column(name = "is_account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "is_account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "is_credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "is_enabled")
    private boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof D002001)) {
            return false;
        }
        return id != null && id.equals(((D002001) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}