package com.poc.repositories.core;

import com.poc.entities.core.D002001;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>User Repository</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@Repository("D002001Repository")
public interface D002001Repository extends JpaRepository<D002001,Long> {
}
