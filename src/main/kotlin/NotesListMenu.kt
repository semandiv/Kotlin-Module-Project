import java.util.Scanner

class NotesListMenu(name: String, scanner: Scanner, val items: MutableList<Note>): Menu(name, scanner) {

    fun selectItem() {
        var select: Int
        if (items.isNotEmpty()) {
            do {
                select = readIntInput(items.size + 1)
                when (select) {
                    0 -> addItem(items)
                    in 1..items.size -> {
                        val note = items[select - 1]
                        showNote(note)
                    }
                }
            }while (select != (items.size + 1))
        } else {
            select = readIntInput(1)
            when(select){
                0 -> addItem(items)
                1 -> return
            }
        }
        this.printMenu(items)
        this.selectItem()
        return
    }
}

