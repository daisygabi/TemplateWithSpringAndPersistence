package com.remote.developers.persistence;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;

/**
 * Helper methods to transform domain objects into dtos and vice-versa
 */
public class EntityHelper {
    public static <TResult> TResult convertToAbstractEntity(Object dto, Class<TResult> classReference) {
        try {
            return new ModelMapper().map(dto, classReference);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error converting to entity." + e.getMessage(), e);
        }
    }

    public static <TResult> TResult convertToAbstractDto(Object obj, Class<TResult> classReference) {
        try {
            return new ModelMapper().map(obj, classReference);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error converting to entity." + e.getMessage(), e);
        }
    }
}
