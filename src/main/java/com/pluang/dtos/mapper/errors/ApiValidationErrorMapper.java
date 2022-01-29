package com.pluang.dtos.mapper.errors;

import com.pluang.dtos.response.errors.ApiValidationErrorResponseDto;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

public interface ApiValidationErrorMapper {

    List<ApiValidationErrorResponseDto> getApiValidationErrors(Set<ConstraintViolation<?>> constraintViolations);

    ApiValidationErrorResponseDto getApiValidationError(FieldError fieldError);

    ApiValidationErrorResponseDto getApiValidationError(ObjectError objectError);

}