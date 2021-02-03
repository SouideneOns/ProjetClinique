package cliniquemvc_example.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cliniquemvc_example.form.UserForm;
import cliniquemvc_example.form.maladeForm;
import cliniquemvc_example.form.rendezForm;
import cliniquemvc_example.service.UserService;


@Component
public class CustomerValidator implements Validator {
	 @Autowired
	 UserService userService;
	 
   public boolean supports(Class<?> clazz) {
      return  UserForm.class.equals(clazz) || maladeForm.class.equals(clazz) || rendezForm.class.equals(clazz);
   }

   public void validate(Object obj, Errors err) {

	 
     
 if (obj instanceof UserForm) {
      	  UserForm user = (UserForm) obj;
      	 ValidationUtils.rejectIfEmpty(err, "username", "user.username.empty");
		      ValidationUtils.rejectIfEmpty(err, "password", "user.password.empty");
		      ValidationUtils.rejectIfEmpty(err, "confirmPassword", "user.confirmPassword.empty");
      	  if(user.getPassword() != null && user.getConfirmPassword() != null && 
      			!user.getPassword().equals(user.getConfirmPassword())){
      			   err.rejectValue("password", "notMatch.confirmPassword");
      			  }
      			  
      			  if(userService.userExists(user.getUsername())){
      			   err.rejectValue("username", "exists.username");
      			  }
      			  
      			   Pattern pattern2 = Pattern.compile("^(09|11|12|10)+[0-9]{6}$",
      		              Pattern.CASE_INSENSITIVE);
      		        if (!(pattern2.matcher(user.getPassword()).matches())) {
      		           err.rejectValue("password", "user.password.invalid");
      		        }
      			
      	  
        }
 

        
   }

}