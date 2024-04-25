import java.util.Scanner

class ArchivesListMenu(name: String, scanner: Scanner, val items: MutableList<Archive>): Menu(name, scanner) {

    fun selectItem(){
        if (items.isNotEmpty()){
            var select: Int
            do {
                select = readIntInput(items.size+1)
                when(select){
                    0 -> addItem(items)
                    in 1..items.size -> {
                        val archive = items[select-1]
                        val notesList = NotesListMenu("Список заметок в архиве:", scanner, archive.notes)
                        notesList.printMenu(notesList.items)
                        notesList.selectMenu()
                        this.printMenu(items)


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
}
