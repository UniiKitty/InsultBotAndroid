package simez.com.insultbot

class InsultGenerator() {
    init {

    }

    fun generate(): String {
        return pickOne(listOf(
            "Item one",
            "Item two",
            "Item three"
        ))
    }

    private fun pickOne(list: List<String>): String {
        return list.shuffled().take(1).first()
    }
}