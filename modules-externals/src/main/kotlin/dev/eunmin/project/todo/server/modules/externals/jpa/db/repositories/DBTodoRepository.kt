package dev.eunmin.project.todo.server.modules.externals.jpa.db.repositories

import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_Todo
import org.springframework.data.jpa.repository.JpaRepository

interface DBTodoRepository: JpaRepository<T_Todo, Long>