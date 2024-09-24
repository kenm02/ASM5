package repository

data class Theater(
    val theaterName: String,
    val address: String,
    val contact: String,
    val movies: List<Movie>,
    val prices: List<Price>,
    val rooms: List<Room>
)

data class Movie(
    val movieName: String,
    val movieCode: String,
    val startDate: String,
    val endDate: String,
    val schedule: List<String>,
    val duration: Int,
    val showTime: List<Any>
)


data class ShowTime(
    val time: String,
    val type: String,
    val room: String
)

data class Price(
    val movieType: String,
    val price: Double
)

data class Room(
    val name: String,
    val map: List<List<Int>>
)

