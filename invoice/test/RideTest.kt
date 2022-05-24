import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly

class RideTest: StringSpec() {
    init {
        "should return 0.0 for 0 km and 0 minutes" {
            val ride = Ride(0.0, 0.0)
            val calculateFare = ride.calculateFare()
            calculateFare shouldBeExactly  0.0
        }

        "should return 10 for 1 km and 0 minutes" {
            val ride = Ride(1.0, 0.0)
            val calculateFare = ride.calculateFare()
            calculateFare shouldBeExactly 10.0
        }

        "should return 1 for 0 km and 1 minute" {
            val ride = Ride(0.0, 1.0)
            val calculateFare = ride.calculateFare()
            calculateFare shouldBeExactly 1.0
        }

        "should return 11 for 1 km and 1 minute" {
            val ride = Ride(1.0, 1.0)
            val calculateFare = ride.calculateFare()
            calculateFare shouldBeExactly 11.0
        }
    }
}
