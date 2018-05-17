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

    fun pickOne(list: List<String>): String {
        return list.shuffled().take(1).first()
    }
}