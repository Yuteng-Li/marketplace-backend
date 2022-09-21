package nisum.marketplace.backend.exception;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class GlobalExceptionHandler {
    /** Provides handling for exceptions throughout this service. */
    @ExceptionHandler({ AddressNotFoundException.class , AddressAlreadyExistsException.class})
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof AddressNotFoundException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            AddressNotFoundException unfe = (AddressNotFoundException) ex;

            return handleAddressNotFoundException(unfe, headers, status, request);
        } 
        else if (ex instanceof AddressAlreadyExistsException) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            AddressAlreadyExistsException cnae = (AddressAlreadyExistsException) ex;

            return handleAddressAlreadyExistsException(cnae, headers, status, request);
        } 
        else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, null, headers, status, request);
        }
    }

    /** Customize the response for UserNotFoundException. */
    protected ResponseEntity<ApiError> handleAddressNotFoundException(AddressNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
    }
    
    protected ResponseEntity<ApiError> handleAddressAlreadyExistsException(AddressAlreadyExistsException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
    }

    /** Customize the response for ContentNotAllowedException. */
//    protected ResponseEntity<ApiError> handleContentNotAllowedException(ContentNotAllowedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        List<String> errorMessages = ex.getErrors()
//                .stream()
//                .map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        return handleExceptionInternal(ex, new ApiError(errorMessages), headers, status, request);
//    }

    /** A single place to customize the response body of all Exception types. */
    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
    
    
}
