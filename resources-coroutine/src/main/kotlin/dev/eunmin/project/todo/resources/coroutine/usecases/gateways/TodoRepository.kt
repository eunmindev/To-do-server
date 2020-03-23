package dev.eunmin.project.todo.resources.coroutine.usecases.gateways

import dev.eunmin.project.todo.server.modules.commons.exceptions.NoContentException
import dev.eunmin.project.todo.server.modules.commons.extensions.unwrap
import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo
import dev.eunmin.project.todo.server.modules.externals.jpa.db.repositories.DBTodoRepository

interface TodoRepository {
    suspend fun getTodo(id: Long): T_Todo
    suspend fun getTodos(): List<T_Todo>
    suspend fun saveTodo(todo: T_Todo): T_Todo
    suspend fun deleteTodo(id: Long)
}

class TodoRepositoryImpl(private val dbTodoRepository: DBTodoRepository): TodoRepository {
    override suspend fun getTodo(id: Long): T_Todo
            = dbTodoRepository.findById(id).unwrap()?: throw NoContentException("죄송합니다. Todo가 존재하지 않습니다.")

    override suspend fun getTodos(): List<T_Todo> = dbTodoRepository.findAll()

    override suspend fun saveTodo(todo: T_Todo): T_Todo = dbTodoRepository.save(todo)

    override suspend fun deleteTodo(id: Long) = dbTodoRepository.deleteById(id)
}