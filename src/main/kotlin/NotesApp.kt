import java.util.InputMismatchException
import java.util.Scanner

class NotesApp {

    val archiveList: MutableList<Archive> = mutableListOf()
    val noteList: MutableList<Note> = mutableListOf()
    val scanner = Scanner(System.`in`)

    fun start(){
        val mainMenu = ArchivesListMenu("Список архивов", scanner, archiveList)
        mainMenu.displayMenu()



        return
    }



    private fun readIntInput(max: Int): Int {
        var input: Int
        while (true) {
            println("Введите номер пункта:")
            try {
                input = scanner.nextInt()
                if (input in 0..max) {
                    break
                } else {
                    println("Пожалуйста, введите число от 0 до $max.")
                }
            } catch (e: InputMismatchException) {
                println("Пожалуйста, введите корректное целое число.")
                scanner.next()
            }
        }
        return input
    }


}