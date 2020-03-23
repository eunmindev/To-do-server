package dev.eunmin.project.todo.resources.coroutine.resources.dto.error

data class ErrorDto(
    val errorCode: ErrorCodeDto?,
    val message: String?
)

enum class ErrorCodeDto {
    BAD_PARAMETER,
    NO_CONTENT
}