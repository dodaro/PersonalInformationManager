package it.unical.ea.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.PropertyAccessorUtils;
import org.springframework.core.env.PropertiesPropertySource;

import it.unical.ea.model.User;


public class FieldMatchValidator 
	implements ConstraintValidator<FieldMatch, Object>{
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
    	

    	
        try
        {
            final Object firstObj = BeanUtils.getPropertyDescriptor((Class<?>) value, firstFieldName);
            final Object secondObj = BeanUtils.getPropertyDescriptor(value.getClass(), secondFieldName);

            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
            // ignore
        }
        return true;
    }
}