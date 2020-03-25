package dev.eunmin.project.todo.resources.coroutine.core

import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo

data class Todo (
        val id: Long?,
        val title: String,
        val content: String
)

fun Todo.entity() = T_Todo(id, title, content)