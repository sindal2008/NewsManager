package by.itsupportme.sindalouski.sampletask.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<TitleConstraint, String> {
   public void initialize(TitleConstraint constraint) {
   }

   public boolean isValid(String title, ConstraintValidatorContext context) {
       return  title.length() < 255;
   }
}
