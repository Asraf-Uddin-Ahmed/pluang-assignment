package com.pluang.dtos.mapper.errors.impl;

import com.pluang.constants.ErrorCode;
import com.pluang.dtos.mapper.errors.ApiErrorMapper;
import com.pluang.dtos.mapper.errors.ApiValidationErrorMapper;
import com.pluang.dtos.response.errors.ApiErrorResponseDto;
import com.pluang.services.MessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;

@Component
public class ApiErrorMapperImpl implements ApiErrorMapper {

    private final ApiValidationErrorMapper apiValidationErrorMapper;
    private final MessageSourceService messageSourceService;
    private ApiErrorResponseDto apiErrorResponseDto;

    @Autowired
    protected ApiErrorMapperImpl(ApiValidationErrorMapper apiValidationErrorMapper, MessageSourceService messageSourceService) {
        this.apiValidationErrorMapper = apiValidationErrorMapper;
        this.messageSourceService = messageSourceService;
    }

    public ApiErrorMapper initDefaultValidationError() {
        this.apiErrorResponseDto.setStatus(HttpStatus.BAD_REQUEST);
        this.apiErrorResponseDto.setErrorCode(ErrorCode.VALIDATION_ERROR);
        this.apiErrorResponseDto.setMessage(messageSourceService.getMessage(ErrorCode.VALIDATION_ERROR));
        return this;
    }

    public ApiErrorMapper setStatus(HttpStatus status) {
        this.apiErrorResponseDto.setStatus(status);
        return this;
    }

    public ApiErrorMapper setMessageByErrorCode(String errorCode) {
        this.apiErrorResponseDto.setErrorCode(errorCode);
        this.apiErrorResponseDto.setMessage(messageSourceService.getMessage(errorCode));
        return this;
    }

    public ApiErrorMapper setMessageByErrorCode(String errorCode, Object... params) {
        this.apiErrorResponseDto.setErrorCode(errorCode);
        this.apiErrorResponseDto.setMessage(String.format(messageSourceService.getMessage(errorCode), params));
        return this;
    }

    public ApiErrorMapper setDebugMessage(Throwable exception) {
        this.apiErrorResponseDto.setDebugMessage(exception.getLocalizedMessage());
        return this;
    }

    public ApiErrorMapper addValidationFieldErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
        return this;
    }

    public ApiErrorMapper addValidationObjectErrors(List<ObjectError> objectErrors) {
        objectErrors.forEach(this::addValidationError);
        return this;
    }

    public ApiErrorMapper addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
        this.apiValidationErrorMapper.getApiValidationErrors(constraintViolations)
                .forEach(ave -> this.apiErrorResponseDto.addValidationError(ave));
        return this;
    }

    public ApiErrorMapper initResponseDto() {
        this.apiErrorResponseDto = new ApiErrorResponseDto();
        return this;
    }

    public ApiErrorResponseDto build() {
        return this.apiErrorResponseDto;
    }

    private void addValidationError(FieldError fieldError) {
        this.apiErrorResponseDto.addValidationError(this.apiValidationErrorMapper.getApiValidationError(fieldError));
    }

    private void addValidationError(ObjectError objectError) {
        this.apiErrorResponseDto.addValidationError(this.apiValidationErrorMapper.getApiValidationError(objectError));
    }

}
