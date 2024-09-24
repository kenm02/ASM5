package resource

import repository.TheaterData

object StringResource {
    // show theater information
    const val GRETTING = "Welcom to --${TheaterData.THEATERNAME}--"
    const val SHOW_ADDRESS ="Address: ${TheaterData.ADDRESS}"
    const val SHOW_CONTACT = "Contact: ${TheaterData.CONTACT}"


    //Primary block
    const val START_AND_END_OF_BLOCK ="========================================="
    const val BLOCK_DIVISION ="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
    const val RESULF_BLOCK_DIVISION = "-----------------------------------------------"


    // show option
    const val SHOW_OPTION = """Please choose below option to continue:
    1. View now showing movies
    2. View comming soon movies
    3. view available movies by date
    4. book ticket
    5. exit"""
    const val ASK_USER_ENTER_OPTION = "Your option: "
    
    // view now showing movies
    const val PRINT_OUT_SHOWING_MOVIES = "Movies showing now: "
    const val PRINT_OUT_COMMING_SOON_MOVIES = "Comming soon movies: "
    const val NO_MOVIES_SHOWING_MESSAGE= "There isn't any movie showing now!"
    const val NO_MOVIES_COMMING_SOON_MESSAGE= "There isn't any movie comming soon!"
    // View available movies by date
    const val PRINT_OUT_AVAILABLE_MOVIES ="Available movie in"
    const val NO_MOVIES_AVAILABLE_MESSAGE= "There isn't available movie!"

    //Book ticket
    const val ASK_USER_INPUT_MOVIE_CODE = "Please enter movie code: "

    //Error
    const val DOES_NOT_EXIST_MOVIE_CODE_ERROR = "Movie code does not exist!"
    const val EXIST_BUT_HAS_NOT_YET_BEGUN_ERROR_MESSAGE = "Movie has not yet begun!"
    const val EXIST_BUT_MOVIE_HAS_EXPIRED_ERROR_MESSAGE = "Movie has expired!"
}