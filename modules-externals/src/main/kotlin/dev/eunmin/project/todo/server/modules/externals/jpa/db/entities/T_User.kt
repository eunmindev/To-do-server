package dev.eunmin.project.todo.server.modules.externals.jpa.db.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class T_User (
        @Id @GeneratedValue
        val id: Long?,
        val name: String,
        val email: String,
        val password: String
)