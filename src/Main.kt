import repository.Option
import resource.StringResource
import service.Service

fun main() {
    println(StringResource.START_AND_END_OF_BLOCK)
    println(StringResource.GRETTING)
    println(StringResource.SHOW_ADDRESS)
    println(StringResource.SHOW_CONTACT)
    println(StringResource.START_AND_END_OF_BLOCK)
    println(StringResource.BLOCK_DIVISION)
    while (true){
        println(StringResource.START_AND_END_OF_BLOCK)
        println(StringResource.SHOW_OPTION)
        print(StringResource.ASK_USER_ENTER_OPTION)
        val option = readln()
        when(option){
            Option.VIEW_NOW_SHOWING_MOVIE.value -> {
                Service.viewNowShowingMovies()
            }
            Option.VIEW_COMMING_SOON_MOVIE.value -> {
                Service.viewCommingSoonMovies()
            }
            Option.VIEW_AVAILABLE_MOVIES_BY_DATE.value -> {
                print("Taget date: ")
                val tagetDate = readln()
                Service.viewAvailableMoviesByDate(tagetDate)
            }
            Option.BOOK_STICKET.value -> {
                Service.bookTicket()
            }
            Option.EXIT.value -> {
                return
            }
        }
        println(StringResource.START_AND_END_OF_BLOCK)
        println(StringResource.BLOCK_DIVISION)
    }

}