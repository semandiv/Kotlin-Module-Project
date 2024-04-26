import java.util.Scanner

fun main() {

    val archiveList: MutableList<Archive> = mutableListOf() //пустой список архивов без заметок
    val scanner = Scanner(System.`in`)

    val mainMenu = ArchivesListMenu("Список архивов", scanner, archiveList)
    mainMenu.start()

}