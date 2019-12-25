package com.poc.services.core;

import com.poc.constants.MessageConstants;
import com.poc.entities.core.D002000;
import com.poc.framework.exceptions.ResourceNotFoundException;
import com.poc.repositories.core.D002000Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service("D002000Service")
public class D002000Service {
    @Autowired
    private D002000Repository d002000Repository;

    public List<D002000> browse() {
        return d002000Repository.findAll();
    }

    public D002000 browseById(int id) {
        Optional<D002000> d002000 = d002000Repository.findById(id);
        if(d002000.isEmpty()){
            throw new ResourceNotFoundException(id,
                    ZonedDateTime.now(),
                    MessageConstants.RESOURCE_NOT_FOUND);
        }
        return d002000.get();
    }

    public D002000 create(D002000 d002000) {
        return d002000Repository.save(d002000);
    }

    public D002000 modify(int id, D002000 d002000) {
        Optional<D002000> d002000Validate = d002000Repository.findById(id);
        if(d002000Validate.isEmpty()){
            throw new ResourceNotFoundException(id,
                    ZonedDateTime.now(),
                    MessageConstants.RESOURCE_NOT_FOUND);
        }
        D002000 modifyD002000 = d002000Validate.get();
        modifyD002000.setDatabaseVersion(d002000.getDatabaseVersion());
        modifyD002000.setDatabase(d002000.getDatabase());
        modifyD002000.setDatabaseName(d002000.getDatabaseName());
        modifyD002000.setSchemaName(d002000.getSchemaName());
        modifyD002000.setEnabled(d002000.isEnabled());
        modifyD002000.setTenantName(d002000.getTenantName());
        modifyD002000 = d002000Repository.save(modifyD002000);
        return modifyD002000;
    }

    public void deleteById(int id) {
        d002000Repository.deleteById(id);
    }
}
