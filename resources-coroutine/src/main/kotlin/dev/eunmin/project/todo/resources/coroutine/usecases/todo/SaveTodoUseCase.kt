package dev.eunmin.project.todo.resources.coroutine.usecases.todo

import dev.eunmin.project.todo.resources.coroutine.core.Todo
import dev.eunmin.project.todo.resources.coroutine.core.entity
import dev.eunmin.project.todo.server.modules.commons.usecase.UseCase
import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo
import dev.eunmin.project.todo.resources.coroutine.usecases.gateways.TodoRepository
import org.springframework.stereotype.Service

@Service
class SaveTodoUseCase (
        private val todoRepository: TodoRepository
): UseCase<Todo, T_Todo> {
    override suspend fun execute(request: Todo): T_Todo = todoRepository.saveTodo(request.entity())
}