
class Invoice {
    companion object {
        val RATE_PER_KM = 10.0
        val RATE_PER_MIN = 1.0
    }
    fun create(rides: List<Ride>): Double {
        val ride = rides[0]
        return ride.dist * RATE_PER_KM + ride.time * RATE_PER_MIN
    }

}
