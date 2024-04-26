import java.util.InputMismatchException
import java.util.Scanner

open class Menu(val name: String, val scanner: Scanner) {

    //дженерик-метод, добавляет новый объект в список
    inline fun <reified T> addItem(list: MutableList<T>){
        when (T::class.qualifiedName){
            "Archive" -> {
                val name = readStringInput("Введите название архива:")
                list.add(Archive(name, mutableListOf()) as T)
                println("Новый архив $name создан, добавьте в него заметки.")
            }
            "Note" -> {
                val name = readStringInput("Введите название заметки:")
                val text = readStringInput("Введите текст заметки:")
                list.add(Note(name, text) as T)
                println("Новая заметка $name создана.")
            }
        }
    }
    //дженерик-метод, собирает из списка пункты меню и отображает на экране
    inline fun <reified T> printMenu(list: MutableList<T>) {
        println(this.name)
        println("0. Добавить новый элемент")
        if (list.isNotEmpty()){
            for ((index, item) in list.withIndex()){
                when (T::class.qualifiedName) {
                    "Archive" -> {
                        val archive = item as Archive
                        println("${index + 1}. ${archive.name}")
                    }
                    "Note" -> {
                        val note = item as Note
                        println("${index + 1}. ${note.name}")
                    }
                }

            }
            println("${list.size + 1}. Выход")
        } else println("1. Выход")
    }

    //выводит на экран заметку с названием и содержимым
    //задумывал, если будет время, сделать текст заметок многострочным, но не успеваю уже((
    fun showNote(note: Note){
        println("Заметка ${note.name}")
        println(note.text)

        println("Введите 0 для возврата в предыдущее меню:")
        var input: Int
        while (true){
            try {
                input = scanner.nextInt()
                if (input == 0) {
                    break
                } else {
                    println("Пожалуйста, введите число 0 для выхода.")
                }
            } catch (e: InputMismatchException) {
                println("Пожалуйста, введите корректное число.")
                scanner.next()
            }
        }
    }

    //метод для чтения строк с клавиатуры
    //используется для указания названий для архивов, заметок и текстов заметок
    fun readStringInput(message: String): String {
        var input: String
        println(message)
        do {
            input = scanner.nextLine().trim()
        } while (input.isEmpty())

        return input
    }

    //метод для чтения целых чисел с клавиатуры для выбора пункта меню
    //в нем проверяем, что введенное число есть в меню на экране
    fun readIntInput(max: Int): Int {
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