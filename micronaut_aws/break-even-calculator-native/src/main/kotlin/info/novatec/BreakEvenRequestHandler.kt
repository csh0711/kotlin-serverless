package info.novatec

import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler
import kotlin.math.ceil

@Introspected
class BreakEvenRequestHandler : MicronautRequestHandler<BreakEvenRequest, BreakEvenResponse>() {

    override fun execute(input: BreakEvenRequest): BreakEvenResponse {
        val breakEvenPoint = ceil(input.fixedCosts / (input.price - input.unitCosts)).toInt()
        return BreakEvenResponse().apply { this.breakEvenPoint = breakEvenPoint }
    }
}

@Introspected
class BreakEvenRequest {
    var price: Double = 0.00
    var unitCosts: Double = 0.00
    var fixedCosts: Double = 0.00
}

@Introspected
class BreakEvenResponse {
    var breakEvenPoint: Int? = null
}

