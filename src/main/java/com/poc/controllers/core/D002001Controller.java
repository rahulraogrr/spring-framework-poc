package com.poc.controllers.core;

import com.poc.constants.MessageConstants;
import com.poc.entities.core.D002001;
import com.poc.services.core.D002001Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@Api(tags = "User Master")
public class D002001Controller {

    @Autowired
    private D002001Service d002001Service;

    @GetMapping("users")
    public ResponseEntity<List<D002001>> browse(){
        return new ResponseEntity<>(d002001Service.browse(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<D002001> browseById(@PathVariable long id){
        return new ResponseEntity<>(d002001Service.browseById(id),HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<String> create(@Valid @RequestBody D002001 d002001){
        D002001 d002001Created = d002001Service.create(d002001);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(d002001Created.getId()).toUri())
                .build();
    }

    @PutMapping("users/{id}")
    public ResponseEntity<String> modify(@PathVariable long id,
                                         @Valid @RequestBody D002001 d002001){
        D002001 d002001modified = d002001Service.modify(id,d002001);
        return new ResponseEntity<>(MessageConstants.RESOURCE_MODIFY_SUCCESS+
                MessageConstants.MESSAGE_SEPARATE+d002001modified.getId(),
                HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        d002001Service.deleteById(id);
        return new ResponseEntity<>(MessageConstants.RESOURCE_DELETE_SUCCESS,
                HttpStatus.OK);
    }
}
