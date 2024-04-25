import java.util.Scanner

class ArchivesListMenu(name: String, scanner: Scanner, val items: MutableList<Archive>): Menu(name, scanner) {

    fun selectItem(){
        var select: Int
        if (items.isNotEmpty()){
            do {
                select = readIntInput(items.size+1)
                when(select){
                    0 -> addItem(items)
                    in 1..items.size -> {
                        val archive = items[select-1]
                        val notesList = NotesListMenu("Список заметок в архиве:", scanner, archive.notes)
                        notesList.printMenu(notesList.items)
                        notesList.selectItem()
                    }
                }
            } while (select != (items.size + 1))
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

