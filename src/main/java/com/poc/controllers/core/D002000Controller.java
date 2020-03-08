package com.poc.controllers.core;

import com.poc.constants.MessageConstants;
import com.poc.entities.core.D002000;
import com.poc.services.core.D002000Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>Tenant Controller</p>
 *
 * @author Rahul Rao Gonda
 */
@RestController
@RequestMapping("secure")
@Api(tags = "Tenant Master")
public class D002000Controller {

    @Autowired
    private D002000Service d002000Service;

    @GetMapping("tenant")
    public ResponseEntity<List<D002000>> browse(){
        return new ResponseEntity<>(D002000Service.browse.get(),
                HttpStatus.OK);
    }

    @GetMapping("tenant/{id}")
    public ResponseEntity<D002000> browseById(@PathVariable int id){
        return new ResponseEntity<>(d002000Service.browseById.apply(id),
                HttpStatus.OK);
    }

    @PostMapping("tenant")
    public ResponseEntity<String> create(@Valid @RequestBody D002000 d002000){
        D002000 d002000Created = d002000Service.create.apply(d002000);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(d002000Created.getId()).toUri())
                .build();
    }

    @PutMapping("tenant/{id}")
    public ResponseEntity<String> modify(@PathVariable int id,
                                         @Valid @RequestBody D002000 d002000){
        D002000 d002000modified = d002000Service.modify.apply(id,d002000);
        return new ResponseEntity<>(MessageConstants.RESOURCE_MODIFY_SUCCESS+
                MessageConstants.MESSAGE_SEPARATE+d002000modified.getId(),
                HttpStatus.OK);
    }

    @DeleteMapping("tenant/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        d002000Service.deleteById.accept(id);
        return new ResponseEntity<>(MessageConstants.RESOURCE_DELETE_SUCCESS,
                HttpStatus.OK);
    }
}
