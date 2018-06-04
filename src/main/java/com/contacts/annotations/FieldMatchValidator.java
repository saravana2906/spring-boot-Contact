package com.contacts.annotations;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class FieldMatchValidator implements ConstraintValidator<Matches,Object>{
	
	private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final Matches constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
        try
        {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
System.out.println("Comparing strings");
            boolean flag=(firstObj == null )&& (secondObj == null) || (firstObj != null && firstObj.equals(secondObj));
            
            //you can just return the falg to display class level validatio
            //To display field specific error we need below context to set constraint violation to
            //specific field
            if(!flag)
            {
            	context.disableDefaultConstraintViolation();
            	System.out.println("Error display");
                context.buildConstraintViolationWithTemplate("Password error").addPropertyNode(firstFieldName).addConstraintViolation();
            }
            return flag;
            
        }
        catch (final Exception ignore)
        {
            // ignore
        }
        return true;
    }

}
