package com.portal.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.portal.constraints.validator.FieldMatchValidator;

/**
 * Validation annotation to validate that 2 fields have the same value. An array
 * of fields and their matching confirmation fields can be supplied.
 * 
 * Example, compare 1 pair of fields:
 * 
 * <code>
 * <p>&#64;FieldMatch(first = "password", second = "confirmPassword", message =
 *                   "The password fields must match")
 * 
 * <p>Example, compare more than 1 pair of fields:
 * <p>&#64;FieldMatch.List({
 * <br>&#64;FieldMatch(first = "password", second = "confirmPassword", message =
 *                   "The password fields must match"),
 * <br>&#64;FieldMatch(first = "email", second = "confirmEmail", message =
 *                   "The email fields must match")})
 * </code>
 */
@Target( {TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {

    public String message() default "{com.att.dvc.validation.constraints}";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

    /**
     * @return The first field
     */
    public String first();

    /**
     * @return The second field
     */
    public String second();

    /**
     * Defines several <code>@FieldMatch</code> annotations on the same element
     * 
     * @see FieldMatch
     */
    @Target( {TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    public @interface List {

        FieldMatch[] value();
    }
}
