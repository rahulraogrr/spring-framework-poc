package com.poc.entities.core;

import com.poc.constants.AppConstants;
import com.poc.constants.SequenceGenConstants;
import com.poc.constants.enumerations.Gender;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>User Entity</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@Entity
@Table(name = "D002001")
@Data
public class D002001 implements Serializable {

    public static final long serialVersionUID = AppConstants.SERIAL_VERSION_UID;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SequenceGenConstants.D002001_SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SequenceGenConstants.D002001_SEQUENCE_GENERATOR,
            sequenceName = SequenceGenConstants.D002001_SEQUENCE_GENERATOR,
            allocationSize = SequenceGenConstants.D002001_SEQ_ALLOCATION_SIZE)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 1,max = 50)
    @Column(name = "username",unique = true,
            nullable = false,length = 50)
    private String username;

    @NotNull
    @Size(min = 8,max = 100)
    @Column(name = "password",nullable = false,length = 100)
    private String password;

    @Size(max = 100)
    @Column(name = "first_name",length = 100,nullable = false)
    private String firstName;

    @Size(max = 100)
    @Column(name = "middle_name",length = 100)
    private String middleName;

    @Size(max = 100)
    @Column(name = "last_name",length = 100)
    private String lastName;

    @Size(min = 10,max = 254)
    @Email
    @Column(name = "email",length = 254,unique = true,
    nullable = false)
    private String email;

    @Column(name = "gender_id",nullable = false)
    private Gender genderId;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Size(max = 256)
    @Column(name = "image_url",length = 256)
    private String imageUrl;

    @Column(name = "lang_key")
    private String langKey;

    @Type(type = "numeric_boolean")
    @Column(name = "is_account_non_expired")
    private boolean accountNonExpired;

    @Type(type = "numeric_boolean")
    @Column(name = "is_account_non_locked")
    private boolean accountNonLocked;

    @Type(type = "numeric_boolean")
    @Column(name = "is_credentials_non_expired")
    private boolean credentialsNonExpired;

    @Type(type = "numeric_boolean")
    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "status")
    private int status;

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        D002001 d002001 = (D002001) o;

        return new EqualsBuilder()
                .append(getId(), d002001.getId())
                .append(isAccountNonExpired(), d002001.isAccountNonExpired())
                .append(isAccountNonLocked(), d002001.isAccountNonLocked())
                .append(isCredentialsNonExpired(), d002001.isCredentialsNonExpired())
                .append(isEnabled(), d002001.isEnabled())
                .append(getStatus(), d002001.getStatus())
                .append(getUsername(), d002001.getUsername())
                .append(getPassword(), d002001.getPassword())
                .append(getFirstName(), d002001.getFirstName())
                .append(getMiddleName(), d002001.getMiddleName())
                .append(getLastName(), d002001.getLastName())
                .append(getEmail(), d002001.getEmail())
                .append(getGenderId(), d002001.getGenderId())
                .append(getDateOfBirth(), d002001.getDateOfBirth())
                .append(getImageUrl(), d002001.getImageUrl())
                .append(getLangKey(), d002001.getLangKey())
                .isEquals();
    }
}