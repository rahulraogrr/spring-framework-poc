package com.poc.services.core;

import com.poc.constants.MessageConstants;
import com.poc.entities.core.D002001;
import com.poc.framework.exceptions.ResourceNotFoundException;
import com.poc.repositories.core.D002001Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service("D002001Service")
public class D002001Service {
    @Autowired
    private D002001Repository d002001Repository;

    public List<D002001> browse() {
        return d002001Repository.findAll();
    }

    public D002001 browseById(long id) {
        Optional<D002001> d002001 = d002001Repository.findById(id);
        if(d002001.isEmpty()){
            throw new ResourceNotFoundException(id,
                    ZonedDateTime.now(),
                    MessageConstants.RESOURCE_NOT_FOUND);
        }
        return d002001.get();
    }

    public D002001 create(D002001 d002001) {
        return d002001Repository.save(d002001);
    }

    public D002001 modify(long id, D002001 d002001) {
        Optional<D002001> d002001Validate = d002001Repository.findById(id);
        if(d002001Validate.isEmpty()){
            throw new ResourceNotFoundException(id,
                    ZonedDateTime.now(),
                    MessageConstants.RESOURCE_NOT_FOUND);
        }
        D002001 modifyD002001 = d002001Validate.get();

        modifyD002001.setUsername(d002001.getUsername());
        modifyD002001.setPasswordHash(d002001.getPasswordHash());
        modifyD002001.setFirstName(d002001.getFirstName());
        modifyD002001.setMiddleName(d002001.getMiddleName());
        modifyD002001.setLastName(d002001.getLastName());
        modifyD002001.setEmail(d002001.getEmail());
        modifyD002001.setGenderId(d002001.getGenderId());
        modifyD002001.setDob(d002001.getDob());
        modifyD002001.setImageUrl(d002001.getImageUrl());
        modifyD002001.setLangKey(d002001.getLangKey());
        modifyD002001.setAccountNonExpired(d002001.isAccountNonExpired());
        modifyD002001.setCredentialsNonExpired(d002001.isCredentialsNonExpired());
        modifyD002001.setAccountNonLocked(d002001.isAccountNonLocked());
        modifyD002001.setEnabled(d002001.isEnabled());
        modifyD002001.setStatus(d002001.getStatus());

        modifyD002001 = d002001Repository.save(modifyD002001);
        return modifyD002001;
    }

    public void deleteById(long id) {
        d002001Repository.deleteById(id);
    }
}
