package dev.eunmin.project.todo.server.modules.externals.jpa.db.entities

import dev.eunmin.project.todo.server.modules.commons.now
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class T_Todo (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val title: String = "",
        val content: String = "",
        val createDate: LocalDateTime = now(),
        val updateDate: LocalDateTime = now()
)