package Service;

import Framework.ErrorLevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Level {
   ErrorLevel level();
}
