import java.util.Scanner

class NotesListMenu(name: String, scanner: Scanner, val items: MutableList<Note>): Menu(name, scanner) {

    //собственная функция класса-наследника для меню со списком заметок
    //в цикле выводим меню на экран и потом запрашиваем ввод пункта меню
    //после выполнения действия пункта меню (кроме выхода) происходит перерисовка меню с новыми пунктами
    fun start() {
        var select: Int
        do {
            this.printMenu(items)
            select = readIntInput(items.size + 1)
            if (items.isNotEmpty()) {
                when (select) {
                    0 -> this.addItem(items)
                    in 1..items.size -> {
                        val note = items[select - 1]
                        showNote(note)
                    }
                }
            } else if (select == 0) this.addItem(items)
        } while (select != (items.size + 1))
    }
}

