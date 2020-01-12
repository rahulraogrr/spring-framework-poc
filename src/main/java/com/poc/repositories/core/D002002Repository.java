package com.poc.repositories.core;

import com.poc.entities.core.D002002;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Roles Repository</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@Repository("D002002Repository")
public interface D002002Repository extends JpaRepository<D002002,Integer> {
}