package dev.eunmin.project.todo.server.modules.commons.usecase

interface UseCase<in Request, out Response> {
    suspend fun execute(request: Request): Response
}

interface UseCaseExecutor {
    suspend operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request,
        responseConverter: (Response) -> ResponseDto
    ): ResponseDto

    suspend operator fun <RequestDto, Request> invoke(
        useCase: UseCase<Request, Unit>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request
    ) =
        invoke(useCase, requestDto, requestConverter, {})

    suspend operator fun invoke(useCase: UseCase<Unit, Unit>) =
        invoke(useCase, Unit, { })

    suspend operator fun <ResponseDto, Response> invoke(
        useCase: UseCase<Unit, Response>,
        responseConverter: (Response) -> ResponseDto
    ) =
        invoke(useCase, Unit, { }, responseConverter)
}


class UseCaseExecutorImp : UseCaseExecutor {

    override suspend operator fun <RequestDto, ResponseDto, Request, Response> invoke(
        useCase: UseCase<Request, Response>,
        requestDto: RequestDto,
        requestConverter: (RequestDto) -> Request,
        responseConverter: (Response) -> ResponseDto
    ): ResponseDto {
        val request = requestConverter(requestDto)
        val response = useCase.execute(request)
        return responseConverter(response)
    }
}