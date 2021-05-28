package info.novatec

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BreakEvenRequestHandlerTests {

    private val testee = BreakEvenRequestHandler()

    @CsvSource(
        "20.00, 100.00, 10.00, 10",
        "6.00, 1000.00, 4.00, 500",
        "2.30, 333.33, 2.10, 1667",
        "3.00, 8000.00, 1.50, 5334"
    )
    @ParameterizedTest
    fun `test handler`(price: Double, fixedCosts: Double, unitCosts: Double, breakEvenPoint: Int) {
        val request = BreakEvenRequest().apply {
            this.price = price
            this.fixedCosts = fixedCosts
            this.unitCosts = unitCosts
        }

        val result = testee.execute(request)

        assertThat(result.breakEvenPoint).isEqualTo(breakEvenPoint)
        testee.applicationContext.close()
    }
}