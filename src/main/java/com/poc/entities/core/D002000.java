package com.poc.entities.core;

import com.poc.constants.AppConstants;
import com.poc.constants.SequenceGenConstants;
import com.poc.constants.enumerations.Database;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>Tenant Table - This table is created to achieve
 * Software As A Service(SaaS) Model</p>
 *
 * @author Rahul Rao Gonda
 */
@Entity
@Table(name = "D002000")
@Data
public class D002000 implements Serializable {

    public static final long serialVersionUID =
            AppConstants.SERIAL_VERSION_UID;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SequenceGenConstants.D002000_SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SequenceGenConstants.D002000_SEQUENCE_GENERATOR,
    sequenceName = SequenceGenConstants.D002000_SEQUENCE_GENERATOR)
    private int id;

    @Column(name = "db")
    private Database database;

    @Column(name = "db_name",unique = true)
    private String databaseName;

    @Size(min = 1,max = 20)
    @Column(name = "db_version",length = 20)
    private String databaseVersion;

    @Column(name = "schema_name")
    private String schemaName;

    @Type(type = "numeric_boolean")
    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "tenant_name",unique = true)
    private String tenantName;
}