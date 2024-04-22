import java.util.InputMismatchException
import java.util.Scanner

class NotesApp {

    val archives: MutableList<Archive> = mutableListOf()
    val notes: MutableList<Note> = mutableListOf()
    private val scanner = Scanner(System.`in`)

    fun start(){
        val mainMenu = Menu("Список архивов", archives)

        mainMenu.displayMenu()

    }

    private fun readIntInput(prompt: String, max: Int): Int {
        var input: Int
        while (true) {
            print(prompt)
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