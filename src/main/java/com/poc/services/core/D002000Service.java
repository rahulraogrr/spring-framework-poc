package com.poc.services.core;

import com.poc.entities.core.D002000;
import com.poc.repositories.core.D002000Repository;
import com.poc.utils.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.*;

/**
 * <p>Tenant Service</p>
 *
 * @author Rahul Rao Gonda
 */
@Service("D002000Service")
public class D002000Service {
    @Autowired
    private static D002000Repository d002000Repository;

    public static final Supplier<List<D002000>> browse = () -> d002000Repository.findAll();

    public IntFunction<D002000> browseById = id -> {
                Optional<D002000> d002000Validate = validateRecord.apply(id);
                if(d002000Validate.isEmpty())
                    ExceptionUtil.throwResourceNotFoundException.accept(id);
                return d002000Validate.get();
            };

    public Function<D002000,D002000> create =
            d002000 -> d002000Repository.save(d002000);

    public BiFunction<Integer,D002000,D002000> modify = (id,d002000) -> {
        Optional<D002000> d002000Validate = validateRecord.apply(id);
        if(d002000Validate.isEmpty())
            ExceptionUtil.throwResourceNotFoundException.accept(id);
        D002000 modifyD002000 = null;

        if(d002000Validate.isPresent())
         modifyD002000 = d002000Validate.get();

        modifyD002000.setDatabaseVersion(d002000.getDatabaseVersion());
        modifyD002000.setDatabase(d002000.getDatabase());
        modifyD002000.setDatabaseName(d002000.getDatabaseName());
        modifyD002000.setSchemaName(d002000.getSchemaName());
        modifyD002000.setEnabled(d002000.isEnabled());
        modifyD002000.setTenantName(d002000.getTenantName());
        modifyD002000 = d002000Repository.save(modifyD002000);
        return modifyD002000;
    };

    public IntConsumer deleteById = id -> {
        Optional<D002000> d002000Validate = validateRecord.apply(id);
        if(d002000Validate.isEmpty())
            ExceptionUtil.throwResourceNotFoundException.accept(id);

        d002000Validate.ifPresent(d002000 ->
                d002000Repository.deleteById(d002000.getId()));
    };

    static IntFunction<Optional<D002000>> validateRecord = id
            -> d002000Repository.findById(id);
}