package com.poc.entities.core;

import com.poc.constants.SequenceGenConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>Roles Entity</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@Entity
@Table(name = "D002002")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class D002002 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = SequenceGenConstants.D002002_SEQUENCE_GENERATOR)
    @SequenceGenerator(name = SequenceGenConstants.D002002_SEQUENCE_GENERATOR,
    sequenceName = SequenceGenConstants.D002002_SEQUENCE_GENERATOR,
    allocationSize = SequenceGenConstants.D002002_SEQ_ALLOCATION_SIZE)
    private int id;

	@NotNull(message = "Role Description Is Mandatory")
    @Size(min = 1,max = 30,message = "Role Description Should Be Min 1 And Max 30")
    @Column(name = "role_desc",length = 30)
    private String roleDesc;
}