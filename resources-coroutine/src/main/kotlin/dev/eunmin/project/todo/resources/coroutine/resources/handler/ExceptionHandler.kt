package dev.eunmin.project.todo.resources.coroutine.resources.handler

import dev.eunmin.project.todo.resources.coroutine.resources.dto.error.ErrorCodeDto
import dev.eunmin.project.todo.resources.coroutine.resources.dto.error.ErrorDto
import dev.eunmin.project.todo.server.modules.commons.exceptions.BadParameterException
import dev.eunmin.project.todo.server.modules.commons.exceptions.NoContentException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@Controller
@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(BadParameterException::class)
    fun badParameter(ex: BadParameterException)
            = ResponseEntity(ErrorDto(ErrorCodeDto.BAD_PARAMETER, ex.message), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(NoContentException::class)
    fun noContent(ex: NoContentException)
            = ResponseEntity(ErrorDto(ErrorCodeDto.NO_CONTENT, ex.message), HttpStatus.NO_CONTENT)
}