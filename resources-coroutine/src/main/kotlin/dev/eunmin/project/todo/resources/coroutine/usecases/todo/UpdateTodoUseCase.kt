package dev.eunmin.project.todo.resources.coroutine.usecases.todo

import dev.eunmin.project.todo.resources.coroutine.core.Todo
import dev.eunmin.project.todo.server.modules.commons.exceptions.BadParameterException
import dev.eunmin.project.todo.server.modules.commons.now
import dev.eunmin.project.todo.server.modules.commons.usecase.UseCase
import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo
import dev.eunmin.project.todo.resources.coroutine.resources.dto.request.RequestTodo
import dev.eunmin.project.todo.resources.coroutine.usecases.gateways.TodoRepository
import org.springframework.stereotype.Service

@Service
class UpdateTodoUseCase (
        private val todoRepository: TodoRepository
): UseCase<Todo, T_Todo> {
    override suspend fun execute(request: Todo): T_Todo {
        request.id?: throw BadParameterException("죄송합니다. 파라미터 값이 잘 못 되었습니다.")
        val todo = todoRepository.getTodo(request.id).copy(title = request.title, content = request.content, updateDate = now())
        return todoRepository.saveTodo(todo)
    }
}