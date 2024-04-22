class Menu<in T: Date>(private val name: String, private val items: MutableList<T>) {

    fun displayMenu(){

            println(name)
            println("0. Добавить новый элемент")
            if (items.isNotEmpty()) {
                for ((index, item) in items.withIndex()) {
                    println("${index + 1}. ${item.name}")
                }
                println("${items.size + 1}. Выход")
            } else println("1. Выход")
        }

        fun addItem(item: T) {
            items.add(item)
        }
}
