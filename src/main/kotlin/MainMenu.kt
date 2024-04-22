class MainMenu (val storage: MutableList<Archive>){
    val name = "Список архивов:"

    val items: HashMap<Int, Archive> = hashMapOf()

    fun createMenu(){
        if (storage.isNotEmpty()){
            var i = 1
            storage.forEach { it ->
                items[i] = it
                i++
            }
        }

        println(name)
        println("0. Создать архив")
        if (items.isNotEmpty()){
            for ((key, value) in items) {
                println("$key. ${value.name}")
            }
            println("${items.size + 1}. Выход")
        } else println("1. Выход")
    }

    fun selectMenuItem(i: Int){
        if (items.isNotEmpty()){
            when (i){
                0 -> println("Будет создан новый архив")
                in 1..items.size -> println("Архив $i будет просмотрен")
                items.size + 1 -> return
            }
        } else {
            when(i){
                0 -> println("Будет создан новый архив")
                1 -> return
            }
        }
    }

    private fun viewArchive() {
        TODO("Not yet implemented")
    }

    private fun createArchive() {
        TODO("Not yet implemented")
    }


}
