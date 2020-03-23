package dev.eunmin.project.todo.resources.coroutine.config

import dev.eunmin.project.todo.server.modules.commons.usecase.UseCaseExecutorImp
import dev.eunmin.project.todo.server.modules.externals.jpa.db.repositories.DBTodoRepository
import dev.eunmin.project.todo.resources.coroutine.usecases.gateways.TodoRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Module {
    @Bean
    fun provideUseCaseImpl() = UseCaseExecutorImp()

    @Bean
    fun provideTodoRepository(dbTodoRepository: DBTodoRepository) = TodoRepositoryImpl(dbTodoRepository)
}