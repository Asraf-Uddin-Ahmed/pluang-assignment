package com.pluang.dtos.mapper.errors;

import com.pluang.dtos.response.errors.ApiErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

public interface ApiErrorMapper {

	ApiErrorMapper initDefaultValidationError();

	ApiErrorMapper setStatus(HttpStatus status);

	ApiErrorMapper setMessageByErrorCode(String message);

	ApiErrorMapper setMessageByErrorCode(String errorCode, Object... params);

	ApiErrorMapper setDebugMessage(Throwable exception);

	ApiErrorMapper addValidationFieldErrors(List<FieldError> fieldErrors);

	ApiErrorMapper addValidationObjectErrors(List<ObjectError> objectErrors);

	ApiErrorMapper addValidationErrors(Set<ConstraintViolation<?>> constraintViolations);

	ApiErrorMapper initResponseDto();

	ApiErrorResponseDto build();

}