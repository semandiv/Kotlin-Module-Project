import java.util.Scanner

class ArchivesListMenu(name: String, scanner: Scanner, val items: MutableList<Archive>): Menu(name, scanner) {

    //собственная функция класса-наследника для меню со списком архивов
    //в цикле выводим меню на экран и потом запрашиваем ввод пункта меню
    //после выполнения действия пункта меню (кроме выхода) происходит перерисовка меню с новыми пунктами
    fun start(){
        var select: Int
        do {
            this.printMenu(items)
            select = readIntInput(items.size + 1)
            if (items.isNotEmpty()){
                when (select) {
                    0 -> addItem(items)
                    in 1..items.size -> {
                        val archive = items[select - 1]
                        val notesList =
                            NotesListMenu("Список заметок в архиве:", scanner, archive.notes)
                        notesList.start()
                    }
                }
            } else {
                if (select == 0) this.addItem(items)
            }
        } while (select != items.size + 1)
    }
}

