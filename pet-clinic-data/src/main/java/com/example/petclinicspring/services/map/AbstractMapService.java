package com.example.petclinicspring.services.map;

import com.example.petclinicspring.model.BaseEntity;

import java.util.*;

abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null.");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        return Collections.max(
                map.keySet().isEmpty() ? Collections.singleton(0L) : map.keySet()
        ) + 1L;
    }
}
