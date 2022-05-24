class Invoice(rides: List<Ride>) {
    val totalRides = rides.size
    val totalFare: Double = if(rides.isEmpty()) 0.0 else rides.sumOf { it.calculateFare() }
    val avgFare: Double = if(rides.isEmpty()) 0.0 else totalFare / totalRides
}
