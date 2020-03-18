package dev.eunmin.project.todo.server.modules.externals.jpa.db.repositories

import dev.eunmin.project.todo.server.modules.externals.jpa.db.entities.T_User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<T_User, Long>