package dev.eunmin.project.todo.resources.coroutine.resources.dto.request

import dev.eunmin.project.todo.resources.coroutine.core.Todo
import dev.eunmin.project.todo.server.modules.commons.now

data class RequestTodo (
        val title: String,
        val content: String
)

fun RequestTodo.core(id: Long? = null) = Todo(id, title, content)