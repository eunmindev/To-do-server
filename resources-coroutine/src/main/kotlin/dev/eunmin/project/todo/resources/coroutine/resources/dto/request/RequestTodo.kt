package dev.eunmin.project.todo.resources.coroutine.resources.dto.request

import dev.eunmin.project.todo.server.modules.commons.now
import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo

data class RequestTodo (
        val id: Long?,
        val title: String,
        val content: String
)

fun RequestTodo.entity() = T_Todo(null, title, content, now(), now())