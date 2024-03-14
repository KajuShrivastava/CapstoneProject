package ka20203422.development.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(NoDataFoundException.class)
	@ResponseBody ResponseEntity<Object> NoDataNotFoundException()
	{
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("message", "No Data found");
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
		
	}
}
