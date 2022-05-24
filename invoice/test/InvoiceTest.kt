import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly

class InvoiceTest: StringSpec() {
    init {
        "should return 0.0 for 0 km and 0 minutes" {
            val invoice = Invoice()
            val ride = Ride(0.0, 0.0)
            val rides = listOf<Ride>(ride)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 0.0
        }

        "should return 10 for 1 km and 0 minutes" {
            val invoice = Invoice()
            val ride = Ride(1.0, 0.0)
            val rides = listOf<Ride>(ride)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 10.0
        }

        "should return 1 for 0 km and 1 minute" {
            val invoice = Invoice()
            val ride = Ride(0.0, 1.0)
            val rides = listOf<Ride>(ride)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 1.0
        }

        "should return 11 for 1 km and 1 minute" {
            val invoice = Invoice()
            val ride = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 11.0
        }

        "should run for one rides in a month" {
            val invoice = Invoice()
            val ride = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 11.0
        }

        "should run for two rides in a month" {
            val invoice = Invoice()
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride1, ride2)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 22.0
        }

        "should run for two rides having fractional values" {
            val invoice = Invoice()
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(2.5, 1.3)
            val rides = listOf<Ride>(ride1, ride2)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 37.3
        }

        "should run for two rides having fractional values and one having both values equal to zero" {
            val invoice = Invoice()
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(1.5, 1.5)
            val ride3 = Ride(0.0, 0.0)
            val rides = listOf<Ride>(ride1, ride2, ride3)
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 27.5
        }

        "should return 0.0 if no rides are given" {
            val invoice = Invoice()
            val rides = listOf<Ride>()
            val calculateFare = invoice.create(rides)
            calculateFare shouldBeExactly 0.0
        }

    }
}
