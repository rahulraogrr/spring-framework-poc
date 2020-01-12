package com.poc.repositories.core;

import com.poc.entities.core.D002000;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Tenant Repository</p>
 *
 * @author rahulraogonda
 * @since 1.0.0
 * @version 1.0.0
 */
@Repository("D002000Repository")
public interface D002000Repository extends JpaRepository<D002000,Integer> {
}
