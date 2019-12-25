package com.poc.entities.core;

import com.poc.constants.SequenceGenConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Tenant Table - This table is created to achieve
 * Software As A Service(SaaS) Model</p>
 *
 * @since 1.0.0
 * @author Rahul Rao Gonda
 */
@Entity
@Table(name = "D002000")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class D002000 implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SequenceGenConstants.D002000_SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SequenceGenConstants.D002000_SEQUENCE_GENERATOR,
    sequenceName = SequenceGenConstants.D002000_SEQUENCE_GENERATOR)
    private int id;

    @Column(name = "database_name",unique = true)
    private String databaseName;

    @Column(name = "schema_name")
    private String schemaName;

    @Type(type = "numeric_boolean")
    @Column(name = "is_enabled")
    private boolean enabled;

    @Column(name = "tenant_name",unique = true)
    private String tenantName;
}