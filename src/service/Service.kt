package service

import repository.Movie
import repository.TheaterData
import resource.StringResource
import java.text.SimpleDateFormat import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


object Service {

    private val dateFormatter = SimpleDateFormat("dd/MM/yyyy")
    private val currentDate = Date()

    fun viewNowShowingMovies(){
        val nowShowingMoviesList = TheaterData.movies.filter { movie ->
            val startDate = dateFormatter.parse(movie.startDate)
            val endDate = dateFormatter.parse(movie.endDate)
            currentDate in startDate .. endDate
        }.sortedBy { movie -> dateFormatter.parse(movie.startDate)  }

        if (nowShowingMoviesList.isNotEmpty()){
            println("(${nowShowingMoviesList.size}) ${ StringResource.PRINT_OUT_SHOWING_MOVIES }")
            nowShowingMoviesList.forEach{movie ->
                println(StringResource.RESULF_BLOCK_DIVISION)
                println("Movie's name: ${movie.movieName}")
                println("Movie's code: ${movie.movieCode}")
                println("Start date: ${movie.startDate}")
                println("End date: ${movie.endDate}")
                println("Duration: ${movie.duration}")
            }
        }else println(StringResource.NO_MOVIES_SHOWING_MESSAGE)
    }


    fun viewCommingSoonMovies(){
        val commingSoonMoviesList = TheaterData.movies.filter { movie ->
            val startDate =  dateFormatter.parse(movie.startDate)
            currentDate.before(startDate)
        }.sortedBy { movie ->  dateFormatter.parse(movie.startDate) }

        if (commingSoonMoviesList.isNotEmpty()){
            println(StringResource.PRINT_OUT_COMMING_SOON_MOVIES)
            commingSoonMoviesList.forEach{movie ->
                println(StringResource.RESULF_BLOCK_DIVISION)
                println("Movie's name: ${movie.movieName}")
                println("Movie's code: ${movie.movieCode}")
                println("Start date: ${movie.startDate}")
                println("End date: ${movie.endDate}")
                println("Duration: ${movie.duration}")
            }
        }else println(StringResource.NO_MOVIES_COMMING_SOON_MESSAGE)
    }

    fun viewAvailableMoviesByDate(targetDate: String){
        val targetDateParsed = dateFormatter.parse(targetDate)
        val dayOfWeek = SimpleDateFormat("EEEE").format(targetDateParsed)
        val availableMoviesList = TheaterData.movies.filter { movie ->
            val startDate = dateFormatter.parse(movie.startDate)
            val endDate = dateFormatter.parse(movie.endDate)
            currentDate in startDate.. endDate && movie.schedule.contains(dayOfWeek)
        }.sortedBy { movie -> dateFormatter.parse(movie.startDate) }

        if (availableMoviesList.isNotEmpty()){
            println("${StringResource.PRINT_OUT_AVAILABLE_MOVIES} ${targetDate}: " )
            availableMoviesList.forEach { movie ->
                println(StringResource.RESULF_BLOCK_DIVISION)
                println("Movie's name: ${movie.movieName}")
                println("Movie's code: ${movie.movieCode}")
                println("Start date: ${movie.startDate}")
                println("End date: ${movie.endDate}")
                println("Duration: ${movie.duration}")
            }
        }else{
            println(StringResource.NO_MOVIES_AVAILABLE_MESSAGE)
        }
    }

    fun bookTicket(){
        fun fillValidDate(movie: Movie):List<LocalDate>{
            val validDate= mutableListOf<LocalDate>()
            val dateFomatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            val endDate= LocalDate.parse(movie.endDate,dateFomatter)
            val schedule = movie.schedule
            var currentDate = LocalDate.now()
            while (currentDate.isBefore(endDate) && validDate.size < 7){
                if (schedule.contains(currentDate.dayOfWeek.toString())){
                    validDate.add(currentDate)
                }
                currentDate = currentDate.plusDays(1)
            }
            return validDate
        }

        while (true){
            print(StringResource.ASK_USER_INPUT_MOVIE_CODE)
            val enteredMovieCode = readln()
            val selectedMovie = TheaterData.movies.find { it.movieCode == enteredMovieCode }

            if (selectedMovie == null){
                println(StringResource.DOES_NOT_EXIST_MOVIE_CODE_ERROR)
                break
            }
            val startDate = dateFormatter.parse(selectedMovie.startDate)
            val endDate = dateFormatter.parse(selectedMovie.endDate)
            if (currentDate < startDate){
                println(StringResource.EXIST_BUT_HAS_NOT_YET_BEGUN_ERROR_MESSAGE)
                break
            }
            else if (currentDate > endDate){
                println(StringResource.EXIST_BUT_MOVIE_HAS_EXPIRED_ERROR_MESSAGE)
                break
            }else{
                println(StringResource.RESULF_BLOCK_DIVISION)
                println("${selectedMovie.movieName} movie's showtimes:")
                val validDate = fillValidDate(selectedMovie)
                validDate.forEachIndexed  { index,date->
                    println("${index+1}.${date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))} ")
                }
                println("0. Exit")
                print("Please select the date that you want to book ticket:")
               while (true){
                   val dateBooking = readln()
                   if (dateBooking > validDate.size.toString()){
                       print("Invalid option! Please select again: ")
                       break
                   }else if (dateBooking == "0") break
               }
//                when (dateBook){
//                    "1" -> {
//                        TODO()
//                    }
//                    "2" -> {
//                        TODO()
//                    }
//                    "3" -> {
//                        TODO()
//                    }
//                    "4" -> {
//                        TODO()
//                    }
//                    "5" -> {
//                        TODO()
//                    }
//                    "6" -> {
//                        TODO()
//                    }
//                    "7" -> {
//                        TODO()
//                    }"0" -> {
//                        TODO()
//                    }
//                }
            }


        }

    }

}