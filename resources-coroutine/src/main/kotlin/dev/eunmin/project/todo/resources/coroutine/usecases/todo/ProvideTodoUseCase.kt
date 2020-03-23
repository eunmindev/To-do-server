package dev.eunmin.project.todo.resources.coroutine.usecases.todo

import dev.eunmin.project.todo.server.modules.commons.usecase.UseCase
import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo
import dev.eunmin.project.todo.resources.coroutine.usecases.gateways.TodoRepository
import org.springframework.stereotype.Service

@Service
class ProvideTodoUseCase (
        private val todoRepository: TodoRepository
): UseCase<Long, T_Todo> {
    override suspend fun execute(request: Long): T_Todo = todoRepository.getTodo(request)
}