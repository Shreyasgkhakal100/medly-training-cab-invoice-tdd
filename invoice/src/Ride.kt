data class Ride (val dist: Double, val time: Double){
    companion object {
        const val RATE_PER_KM = 10.0
        const val RATE_PER_MIN = 1.0
    }
    fun calculateFare(): Double {
        return dist * RATE_PER_KM + time * RATE_PER_MIN
    }
}
