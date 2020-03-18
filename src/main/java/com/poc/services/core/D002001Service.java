package com.poc.services.core;

import com.poc.entities.core.D002001;
import com.poc.repositories.core.D002001Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.LongFunction;

import static com.poc.utils.ExceptionUtil.getResourceNotFoundException;

/**
 * <p>User Service</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@Service("D002001Service")
public class D002001Service {
    @Autowired
    private static D002001Repository d002001Repository;

    public List<D002001> browse() {
        return d002001Repository.findAll();
    }

    public D002001 browseById(Long id) {
        return validateAndGetRecord
                .apply(id)
                .get();
    }

    public D002001 create(D002001 d002001) {
        return d002001Repository.save(d002001);
    }

    public D002001 modify(long id, D002001 d002001) {
        D002001 modifyD002001 = validateAndGetRecord.apply(id).get();

        modifyD002001.setUsername(d002001.getUsername());
        modifyD002001.setPassword(d002001.getPassword());
        modifyD002001.setFirstName(d002001.getFirstName());
        modifyD002001.setMiddleName(d002001.getMiddleName());
        modifyD002001.setLastName(d002001.getLastName());
        modifyD002001.setEmail(d002001.getEmail());
        modifyD002001.setGenderId(d002001.getGenderId());
        modifyD002001.setDateOfBirth(d002001.getDateOfBirth());
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

    private D002001 getD002001ById(long id) {
        return validateAndGetRecord
                .apply(id)
                .get();
    }

    public void deleteById(long id) {
        if(validateAndGetRecord.apply(id).isPresent())
            d002001Repository.deleteById(id);
    }

    private static final LongFunction<Optional<D002001>>
            validateAndGetRecord = id ->
            Optional.ofNullable(d002001Repository
                    .findById(id)
                    .orElseThrow(getResourceNotFoundException(id))
            );

}
