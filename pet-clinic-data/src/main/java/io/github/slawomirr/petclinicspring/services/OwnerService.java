package io.github.slawomirr.petclinicspring.services;

import io.github.slawomirr.petclinicspring.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
