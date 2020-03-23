package dev.eunmin.project.todo.resources.coroutine.usecases.todo

import dev.eunmin.project.todo.server.modules.commons.usecase.UseCase
import dev.eunmin.project.todo.resources.coroutine.usecases.gateways.TodoRepository
import org.springframework.stereotype.Service

@Service
class DeleteTodoUseCase (
        private val todoRepository: TodoRepository
): UseCase<Long, Unit> {
    override suspend fun execute(request: Long) = todoRepository.deleteTodo(request)
}