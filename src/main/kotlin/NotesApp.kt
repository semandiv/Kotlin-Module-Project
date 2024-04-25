import java.util.Scanner

class NotesApp {

    val archiveList: MutableList<Archive> = mutableListOf()
    val scanner = Scanner(System.`in`)

    fun start(){
        val mainMenu = ArchivesListMenu("Список архивов", scanner, archiveList)
        mainMenu.printMenu(mainMenu.items)
        mainMenu.selectItem()
        return
    }
}