package com.poc.services.core;

import com.poc.constants.MessageConstants;
import com.poc.entities.core.D002002;
import com.poc.framework.exceptions.ResourceNotFoundException;
import com.poc.repositories.core.D002002Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;

import static com.poc.utils.ExceptionUtil.getResourceNotFoundException;

/**
 * <p>Roles Service</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@Service("D002002Service")
public class D002002Service {

    @Autowired
    private D002002Repository d002002Repository;

    /**
     * <p>Returns List of {@link D002002}</p>
     *
     * @return List of {@link D002002}
     */
    public List<D002002> browse() {
       return d002002Repository.findAll();
    }

    /**
     * <p>Browse Role By Id</p>
     * @param id Role Id
     * @return {@link D002002}
     */
    public D002002 browseById(int id) {
        /*Optional<D002002> d002002 = d002002Repository.findById(id);
        if(d002002.isEmpty()){
            throw new ResourceNotFoundException(id,
                    ZonedDateTime.now(),
                    MessageConstants.RESOURCE_NOT_FOUND);
        }*/
        return validateAndGetRecord
                .apply(id)
                .get();
    }

    /**
     * <p>Create Role</p>
     * @param d002002 {@link D002002}
     * @return {@link D002002}
     */
    public D002002 create(D002002 d002002) {
        return d002002Repository.save(d002002);
    }

    /**
     * <p>Modify Role</p>
     * @param id Role Id
     * @param d002002 {@link D002002}
     * @return {@link D002002}
     */
    public D002002 modify(int id, D002002 d002002) {
        Optional<D002002> d002002Validate = d002002Repository.findById(id);
        if(d002002Validate.isEmpty()){
            throw new ResourceNotFoundException(id,
                    ZonedDateTime.now(),
                    MessageConstants.RESOURCE_NOT_FOUND);
        }
        D002002 modifyD002002 = d002002Validate.get();
        modifyD002002.setRoleDesc(d002002.getRoleDesc());
        modifyD002002 = d002002Repository.save(modifyD002002);
        return modifyD002002;
    }

    /**
     * <p>Delete Role By Id</p>
     * @param id Role Id
     */
    public void deleteById(int id) {
        d002002Repository.deleteById(id);
    }

    public final IntFunction<Optional<D002002>>
            validateAndGetRecord = id ->
            Optional.ofNullable(d002002Repository
                    .findById(id)
                    .orElseThrow(getResourceNotFoundException(id))
            );
}