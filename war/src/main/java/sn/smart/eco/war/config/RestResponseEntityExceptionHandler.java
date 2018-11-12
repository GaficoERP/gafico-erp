package sn.smart.eco.war.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RequestMapping(produces = "application/json")
@ResponseBody
public class RestResponseEntityExceptionHandler  {
	
	@ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<String> handleAccessDeniedException(Exception ex, WebRequest request) {
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access to the specified resource has been forbidden");
    }
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
		System.out.println(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server error: " + ex.getMessage());
	}

}
