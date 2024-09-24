package repository


object TheaterData {
    const val THEATERNAME = "BHD Movies Theater"
    const val ADDRESS = "123A Street"
    const val CONTACT = "024XXXXXXXXXX"
    val prices = listOf(
        Price(movieType = "3D", 120000.0),
        Price("2D", price = 90000.0)
    )
    val rooms = listOf(
        Room(
            "VIP01",
            listOf(listOf(0, 0, 0, 0, 0, 0, 0, 0), listOf(0, 0, 0, 1, 1, 1, 0, 0), listOf(0, 1, 1, 1, 1, 1, 1, 0))
        ),
        Room(
            "VIP02",
            listOf(listOf(0, 0, 0, 0, 0, 0, 0, 0), listOf(0, 0, 1, 1, 1, 1, 0, 0), listOf(0, 0, 0, 0, 0, 0, 0, 0))
        )
    )
    val movies = listOf(
        Movie(
            movieName = "Adventure end game",
            movieCode = "AVT1",
            startDate = "10/9/2024",
            endDate = "15/09/2024",
            schedule = listOf("TUESDAY", "THURSDAY", "SUNDAY"),
            duration = 120,
            showTime = listOf("19:30", "3D", "VIP01")
        ),
        Movie(
            movieName = "Spider come back home",
            movieCode = "SPD1",
            startDate = "12/08/2024",
            endDate = "18/08/2024",
            schedule = listOf("MONDAY", "WEDNESDAY", "FRIDAY"),
            duration = 90,
            showTime = listOf("19:30", "3D", "VIP01")
        )
    )

}