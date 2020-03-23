package dev.eunmin.project.todo.resources.coroutine.resources.dto.response

import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo
import java.time.LocalDateTime

data class ResponseTodo (
        val id: Long,
        val title: String,
        val content: String,
        val createDate: LocalDateTime,
        val updateDate: LocalDateTime
)

fun T_Todo.dto() = ResponseTodo(id!!, title, content, createDate, updateDate)