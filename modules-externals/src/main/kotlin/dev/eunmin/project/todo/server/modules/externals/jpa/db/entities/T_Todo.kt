package dev.eunmin.project.todo.server.modules.externals.jpa.db.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class T_Todo (
        @Id @GeneratedValue
        val id: Long?,
        val title: String,
        val content: String
)