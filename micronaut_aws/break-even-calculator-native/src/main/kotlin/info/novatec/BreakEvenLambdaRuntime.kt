package info.novatec

import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime

class BreakEvenLambdaRuntime :
    AbstractMicronautLambdaRuntime<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, BreakEvenRequest, BreakEvenResponse>() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>?) = BreakEvenLambdaRuntime().run()
    }

    override fun createRequestHandler(args: Array<String>?): RequestHandler<BreakEvenRequest, BreakEvenResponse> =
        BreakEvenRequestHandler()
}