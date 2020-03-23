package dev.eunmin.project.todo.server.modules.commons

import java.time.LocalDateTime
import java.time.ZoneId

fun now() = LocalDateTime.now(ZoneId.of("Asia/Seoul"))