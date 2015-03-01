package com.portal.constraints.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.portal.constraints.FieldMatch;


/**
 * @see FieldMatch
 *
 */
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
	firstFieldName = constraintAnnotation.first();
	secondFieldName = constraintAnnotation.second();
    }

    @SuppressWarnings("deprecation")
	@Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
	boolean isValid = false;
	try {
	    Object firstObj = BeanUtils.getProperty(value, firstFieldName);
	    Object secondObj = BeanUtils.getProperty(value, secondFieldName);
	    
	    isValid = (firstObj == null && secondObj == null) || (firstObj != null && firstObj.equals(secondObj));
	} catch (Exception ignore) {
	    isValid = false;
	    // ok to ignore, assume any exception means not valid
	}
	
	if(!isValid){
	    context.disableDefaultConstraintViolation();
	    context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addNode(secondFieldName).addConstraintViolation();
	}
	
	return isValid;
    }
    
}
