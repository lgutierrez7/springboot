package com.lgutierrez.crud.error;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lgutierrez.crud.exception.ResourceNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler{// extends ResponseEntityExceptionHandler{

	public RestResponseEntityExceptionHandler() {
        super();
    }

	/*
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<?> handleAuthenticationException(AuthenticationException ex) {
		// return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
		ErrorDetails errorDetails = new ErrorDetails(ex.getCustomCode(), new Date(), ex.getMessage(), ex.getDetails());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}*/

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails("404", new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/*
	@ExceptionHandler(ResourceConflict.class)
	public ResponseEntity<?> resourceForbidden(ResourceConflict ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getCustomCode(), new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}*/
/*
	@ExceptionHandler(value = { Exception.class, NullPointerException.class })
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(Constants.NULL_POINTER_ERROR_CODE, new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RemoteException.class)
	public ResponseEntity<?> globalRemoteExceptionHandler(RemoteException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(Constants.SERVICE_ERROR_CODE, new Date(),
				Constants.SERVICE_ERROR_CODE, request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
*/
	/*
	@ExceptionHandler(FitbankException.class)
	public ResponseEntity<?> fitbankException(FitbankException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getCustomCode(), new Date(), ex.getMessage(), ex.getDetails());
    	if(ex.getCustomCode()!=null && ex.getCustomCode().equalsIgnoreCase(Constants.ERROR_WALLEX_BAD_REQUEST)) {
    		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    	}else if(ex.getCustomCode()!=null && ex.getCustomCode().equalsIgnoreCase(Constants.ERROR_WALLEX_RESOURCE_NOT_FOUND)) {
        		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    	}else {
    		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);	
    	}
		
	}*/


	
/*
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntityy<Object> handleBadRequest(final ConstraintViolationException ex, final WebRequest request) {
        final String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
*/
    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
  //      final String bodyOfResponse = "This should be application specific";
//        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        ErrorDetails errorDetails = new ErrorDetails("500", new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    /*
    
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult result = ex.getBindingResult();
		String fieldName = result.getFieldError().getField().toString();
		String defaultMessage = result.getFieldError().getDefaultMessage();
		String rejectedValue = result.getFieldError().getRejectedValue().toString();
		//String mesage = String.format("%s en \'%s\' con valor \'%s\'", defaultMessage, fieldName, rejectedValue);
		ErrorDetails errorDetails = new ErrorDetails("400", new Date(), defaultMessage,
				request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}*/
}
