package com.ntu.pms.service;

import java.rmi.ServerException;
import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import com.ntu.pms.exception.ValidationException;

public class BaseService {

    protected void validate(Object object) throws ServerException, ValidationException {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(object);
        if (violations.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (ConstraintViolation constraintViolation : violations) {
                builder.append(constraintViolation.getMessage());
            }
            throw new ValidationException(builder.toString());
        }
    }
}
