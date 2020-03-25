package dev.eunmin.project.todo.resources.coroutine.resources.api

import dev.eunmin.project.todo.server.modules.commons.usecase.UseCaseExecutor
import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo
import dev.eunmin.project.todo.resources.coroutine.resources.dto.request.RequestTodo
import dev.eunmin.project.todo.resources.coroutine.resources.dto.request.core
import dev.eunmin.project.todo.resources.coroutine.resources.dto.response.ResponseTodo
import dev.eunmin.project.todo.resources.coroutine.resources.dto.response.dto
import dev.eunmin.project.todo.resources.coroutine.usecases.todo.*
import org.springframework.web.bind.annotation.*

@RestController
class TodoController (
        private val useCaseExecutor: UseCaseExecutor,
        private val provideTodoUseCase: ProvideTodoUseCase,
        private val provideTodosUseCase: ProvideTodosUseCase,
        private val saveTodoUseCase: SaveTodoUseCase,
        private val updateTodoUseCase: UpdateTodoUseCase,
        private val deleteTodoUseCase: DeleteTodoUseCase
) {
    @GetMapping("/todo/{id}")
    suspend fun provideTodo(@PathVariable id: Long): ResponseTodo = useCaseExecutor(
            useCase = provideTodoUseCase,
            requestDto = id,
            requestConverter = { it },
            responseConverter = { it.dto() }
    )

    @GetMapping("/todos")
    suspend fun provideTodos(): List<ResponseTodo> = useCaseExecutor(
            useCase = provideTodosUseCase,
            responseConverter = { it.map(T_Todo::dto) }
    )


    @PostMapping("/todo")
    suspend fun saveTodo(@RequestBody request: RequestTodo): ResponseTodo = useCaseExecutor(
            useCase = saveTodoUseCase,
            requestDto = request,
            requestConverter = { it.core() },
            responseConverter = { it.dto() }
    )

    @PutMapping("/todo/{id}")
    suspend fun updateTodo(@PathVariable id: Long, @RequestBody request: RequestTodo): ResponseTodo  = useCaseExecutor(
            useCase = updateTodoUseCase,
            requestDto = request,
            requestConverter = { it.core(id) },
            responseConverter = { it.dto() }
    )

    @DeleteMapping("/todo/{id}")
    suspend fun deleteTodo(@PathVariable id: Long) = useCaseExecutor(
            useCase = deleteTodoUseCase,
            requestDto = id,
            requestConverter = { it }
    )
}