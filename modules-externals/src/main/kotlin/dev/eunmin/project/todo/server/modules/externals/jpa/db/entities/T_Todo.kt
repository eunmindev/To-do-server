package dev.eunmin.project.todo.server.modules.externals.jpa.db.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class T_Todo (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val title: String,
        val content: String,
        val createDate: LocalDateTime,
        val updateDate: LocalDateTime
)