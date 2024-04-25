import java.util.Scanner

class NotesListMenu(name: String, scanner: Scanner, val items: MutableList<Note>): Menu(name, scanner) {

    fun selectItem() {
        if (items.isNotEmpty()) {
            var select: Int
            do {
                select = readIntInput(items.size + 1)
                when (select) {
                    0 -> addItem(items)
                    in 1..items.size -> {
                        val note = items[select - 1]
                        showNote(note)
                        this.printMenu(items)
                    }
                }
            }while (select != (items.size + 1))
        }
    }
}

