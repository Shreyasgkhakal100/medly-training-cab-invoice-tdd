import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly
import io.kotest.matchers.shouldBe

class InvoiceTest: StringSpec() {
    init {
        "should run for one rides in a month" {
            val ride = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride)
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 11.0
        }

        "should run for two rides in a month" {
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride1, ride2)
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 22.0
        }

        "should run for two rides having fractional values" {
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(2.5, 1.3)
            val rides = listOf<Ride>(ride1, ride2)
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 37.3
        }

        "should run for two rides having fractional values and one having both values equal to zero" {
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(1.5, 1.5)
            val ride3 = Ride(0.0, 0.0)
            val rides = listOf<Ride>(ride1, ride2, ride3)
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 27.5
        }

        "should have 0.0 totalFare if no rides are given" {
            val rides = listOf<Ride>()
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 0.0
        }

        "should have totalFare in object" {
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride1, ride2)
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 22.0
        }

        "should return totalRides along with totalFare" {
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride1, ride2)
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 22.0
            invoice.totalRides shouldBe 2
        }

        "should return avgFare along with totalFare & totalRides" {
            val ride1 = Ride(1.0, 1.0)
            val ride2 = Ride(1.0, 1.0)
            val rides = listOf<Ride>(ride1, ride2)
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 22.0
            invoice.totalRides shouldBe 2
            invoice.avgFare shouldBeExactly 11.0
        }

        "should return totalFare, totalRides & avgFare as 0.0 for empty list" {
            val rides = listOf<Ride>()
            val invoice = Invoice(rides)
            invoice.totalFare shouldBeExactly 0.0
            invoice.totalRides shouldBe 0
            invoice.avgFare shouldBeExactly 0.0
        }
    }
}
