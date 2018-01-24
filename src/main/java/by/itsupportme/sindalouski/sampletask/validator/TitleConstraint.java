package by.itsupportme.sindalouski.sampletask.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TitleValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TitleConstraint {

    String message() default "The title can not be more than 255 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
