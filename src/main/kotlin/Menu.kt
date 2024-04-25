import java.util.InputMismatchException
import java.util.Scanner

open class Menu(val name: String, val scanner: Scanner) {

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
            else -> println("Этот объект не является хранилищем архивов или заметок.")
        }
    }

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

    inline fun <reified T> printMenu(list: MutableList<T>) {
        if (list.isNotEmpty()){
            println(this.name)
            println("0. Добавить новый элемент")
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
                println("${list.size + 1}. Выход")
            }
        } else println("1. Выход")
    }

    inline fun <reified T> updateMenu (menu: T){
        when (T::class.qualifiedName){
            "ArchivesListMenu" -> (menu as ArchivesListMenu).printMenu(menu.items)
            "NotesListMenu" -> (menu as NotesListMenu).printMenu(menu.items)
        }
    }

    inline fun <reified T, reified M> selectMenu (list: MutableList<T>, parentMenu: M){
        if (M::class.qualifiedName != "ArchivesListMenu" || M::class.qualifiedName != "NotesListMenu") return
        if (list.isNotEmpty()){
            var select: Int
            do {
                select = readIntInput(list.size+1)
                when(select){
                    0 -> addItem(list)
                    in 1..list.size -> {
                        when(T::class.qualifiedName){
                            "Archive" -> {
                                val archive = list[select-1] as Archive
                                val archivesMenu = NotesListMenu("Список заметок в архиве:", scanner, archive.notes)
                                archivesMenu.printMenu(archivesMenu.items)
                                archivesMenu.selectMenu(archivesMenu.items, parentMenu)
                                updateMenu(parentMenu)
                            }
                            "Note" -> {
                                val note = list[select - 1] as Note
                                showNote(note)
                                updateMenu(parentMenu)
                            }
                        }
                    }
                }

            } while (select != (list.size + 1))
        }
    }

    fun readStringInput(message: String): String {
        var input: String

        do {
            println(message)
            input = scanner.nextLine().trim()
        } while (input.isEmpty())

        return input
    }
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