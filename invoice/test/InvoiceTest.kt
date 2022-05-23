import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly

class InvoiceTest: StringSpec() {
    init {
        "should return 0.0 for 0 km and 0 minutes" {
            val invoice = Invoice()
            val calculateFare = invoice.calc(0.0, 0.0)
            calculateFare shouldBeExactly 0.0
        }

        "should return 10 for 1 km and 0 minutes" {
            val invoice = Invoice()
            val calculateFare = invoice.calc(1.0, 0.0)
            calculateFare shouldBeExactly 10.0
        }

        "should return 1 for 0 km and 1 minute" {
            val invoice = Invoice()
            val calculateFare = invoice.calc(0.0, 1.0)
            calculateFare shouldBeExactly 1.0
        }

        "should return 11 for 1 km and 1 minute" {
            val invoice = Invoice()
            val calculateFare = invoice.calc(1.0, 1.0)
            calculateFare shouldBeExactly 11.0
        }

    }
}
