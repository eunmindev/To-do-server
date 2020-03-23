package dev.eunmin.project.todo.resources.coroutine.config.db

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["dev.eunmin.project.todo.server.modules.externals.jpa.db.entities"])
@EnableJpaRepositories(basePackages = ["dev.eunmin.project.todo.server.modules.externals.jpa.db.repositories"])
class DBConfig