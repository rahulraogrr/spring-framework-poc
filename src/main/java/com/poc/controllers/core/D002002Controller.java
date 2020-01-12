package com.poc.controllers.core;

import com.poc.constants.MessageConstants;
import com.poc.entities.core.D002002;
import com.poc.services.core.D002002Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>Roles Controller</p>
 *
 * @author Rahul Rao Gonda
 * @since 1.0.0
 * @version 1.0.0
 */
@RestController
@RequestMapping("api")
@Api(tags = "Role Master")
public class D002002Controller {

    @Autowired
    private D002002Service d002002Service;

    @GetMapping("roles")
    public ResponseEntity<List<D002002>> browse(){
        return new ResponseEntity<>(d002002Service.browse(), HttpStatus.OK);
    }

    @GetMapping("roles/{id}")
    public ResponseEntity<D002002> browseById(@PathVariable int id){
        return new ResponseEntity<>(d002002Service.browseById(id),HttpStatus.OK);
    }

    @PostMapping("roles")
    public ResponseEntity<String> create(@Valid @RequestBody D002002 d002002){
        D002002 d002002Created = d002002Service.create(d002002);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(d002002Created.getId()).toUri())
                .build();
    }

    @PutMapping("roles/{id}")
    public ResponseEntity<String> modify(@PathVariable int id,
                                         @Valid @RequestBody D002002 d002002){
        D002002 d002002modified = d002002Service.modify(id,d002002);
        return new ResponseEntity<>(MessageConstants.RESOURCE_MODIFY_SUCCESS+
                MessageConstants.MESSAGE_SEPARATE+d002002modified.getId(),
                HttpStatus.OK);
    }

    @DeleteMapping("roles/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        d002002Service.deleteById(id);
        return new ResponseEntity<>(MessageConstants.RESOURCE_DELETE_SUCCESS,
                HttpStatus.OK);
    }
}