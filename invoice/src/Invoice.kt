
class Invoice {
    companion object {
        val RATE_PER_KM = 10.0
        val RATE_PER_MIN = 1.0
    }
    fun calc(dist: Double, time: Double): Double {
        return dist * RATE_PER_KM + time * RATE_PER_MIN
    }
}
