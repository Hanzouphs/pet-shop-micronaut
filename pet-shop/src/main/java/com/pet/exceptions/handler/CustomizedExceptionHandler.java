package com.pet.exceptions.handler;

import com.pet.exceptions.ExceptionResponse;
import com.pet.exceptions.RequiredObjectIsNullException;
import com.pet.exceptions.ResourceNotFoundException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import java.util.Date;

@Controller
public class CustomizedExceptionHandler implements ExceptionHandler<Exception, HttpResponse<?>> {

    @Error(global = true)
    @Produces
    public HttpResponse<ExceptionResponse> handleException(HttpRequest request, Exception ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getPath());

        return HttpResponse.serverError(exceptionResponse);
    }

    @Error(status = HttpStatus.NOT_FOUND, global = false)
    @Produces
    public HttpResponse<ExceptionResponse> handleNotFoundException(HttpRequest request, ResourceNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getPath());

        return HttpResponse.notFound(exceptionResponse);
    }

    @Error(status = HttpStatus.BAD_REQUEST, global = true)
    @Produces
    public HttpResponse<ExceptionResponse> handleBadRequestException(HttpRequest request, RequiredObjectIsNullException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getPath());

        return HttpResponse.badRequest(exceptionResponse);
    }

    @Override
    public HttpResponse<?> handle(HttpRequest request, Exception exception) {
        return null;
    }
}
