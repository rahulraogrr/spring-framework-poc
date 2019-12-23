package com.poc.entities.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "D002002")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class D002002 implements Serializable {

	private static final long serialVersionUID = -1865568147795614392L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@NotNull(message = "Role Description Is Mandatory")
    @Size(min = 1,max = 30,message = "Role Description Should Be Min 1 And Max 30")
    @Column(name = "role_desc",length = 30)
    private String roleDesc;
}