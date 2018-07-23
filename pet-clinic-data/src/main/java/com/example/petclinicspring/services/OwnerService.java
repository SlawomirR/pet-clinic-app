package com.example.petclinicspring.services;

import com.example.petclinicspring.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
