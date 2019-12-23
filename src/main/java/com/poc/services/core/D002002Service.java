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

@Service("D002002Service")
public class D002002Service {

    @Autowired
    private D002002Repository d002002Repository;

    public List<D002002> browse() {
       return d002002Repository.findAll();
    }

    public D002002 browseById(int id) {
        Optional<D002002> d002002 = d002002Repository.findById(id);
        if(d002002.isEmpty()){
            throw new ResourceNotFoundException(id,
                    ZonedDateTime.now(),
                    MessageConstants.RESOURCE_NOT_FOUND);
        }
        return d002002.get();
    }

    public D002002 create(D002002 d002002) {
        return d002002Repository.save(d002002);
    }

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

    public void deleteById(int id) {
        d002002Repository.deleteById(id);
    }
}