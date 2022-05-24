
class Invoice {
    fun create(rides: List<Ride>): Double {
        val total = rides.sumOf {
            it.calculateFare()
        }
        return total
    }
}
