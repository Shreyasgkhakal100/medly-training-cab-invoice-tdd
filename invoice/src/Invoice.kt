
class Invoice {
    companion object {
        const val RATE_PER_KM = 10.0
        const val RATE_PER_MIN = 1.0
    }
    fun create(rides: List<Ride>): Double {
        val total = rides.sumOf {
            it.dist * RATE_PER_KM + it.time * RATE_PER_MIN
        }
        return total
    }

}
