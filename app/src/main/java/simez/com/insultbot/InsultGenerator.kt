package simez.com.complibot

class InsultGenerator() {
    init {

    }

    fun generate(): String {
        return pickOne(listOf(
                "I hope ${goodEvents()}",
                "You are ${insertNiceThing()}",
                "Your ${anotherNiceThing()}",
                "You are ${insertNiceThing()} and your ${anotherNiceThing()}",
                "You ${verb()} ${adjective()} than ${allGoodThings()}",
                "You have a big dick" /** Just for Simon ;P */
        )).capitalize().trim() + '.'
    }

    private fun pickOne(list: List<String>): String {
        return list.shuffled().take(1).first()
    }

    private fun isAre(text:String): String {
        if (text == "feet") {
            return text + " are"
        }
        if (text.endsWith("s")) {
            return text + " are"
        }
            return text + " is"
    }

    private fun insertNiceThing(): String {
        return pickOne(listOf(
                "${traits()}",
                "${adjective()} than ${allGoodThings()}",
                "${traits()} and you ${verb()} like ${allGoodThings()}"
        ))
    }

    private fun anotherNiceThing(): String {
        return pickOne(listOf(
                "${relative()} is ${insertNiceThing()}",
                "${isAre(possession())} better than ${allGoodThings()}"
        ))
    }

    private fun allGoodThings(): String {
        return pickOne(listOf (
                "a ${idiomOne()} of ${idiomTwo()}",
                "${goodThings()}"
        ))
    }

    private fun idiomOne(): String {
        return pickOne(listOf(
                "bucket",
                "cloud",
                "shower",
                "meadow",
                "bed",
                "pocketful"
        ))
    }

    private fun idiomTwo(): String {
        return pickOne(listOf(
                "sunshine",
                "puppies",
                "icecream",
                "kittens",
                "baby bunnies",
                "newborn puppies",
                "happiness",
                "cookies",
                "unicorns",
                "carebears",
                "ducklings"
                ))
    }

    private fun relative(): String {
        return pickOne(listOf(
                "brother",
                "sister",
                "father",
                "mother",
                "dog",
                "cat",
                "family"))
    }

    private fun traits(): String {
        return pickOne(listOf(
                "brave",
                "beautiful",
                "pretty",
                "a saint",
                "dependable",
                "kind",
                "delightful",
                "wonderful",
                "cute",
                "my favourite person",
                "amazing",
                "talented",
                "precious",
                "smart",
                "intelligent",
                "sweet",
                "humorous"
        ))
    }

    private fun verb(): String {
        return pickOne(listOf(
                "look",
                "sound",
                "walk",
                "talk",
                "smell",
                "smile",
                "laugh",
                "dance",
                "sing"
        ))
    }

    private fun possession(): String {
        return pickOne(listOf(
                "hat",
                "shoes",
                "laughter",
                "smile",
                "style",
                "hair",
                "eyes",
                "lips",
                "hands",
                "feet"
        ))
    }

    private fun adjective(): String {
        return pickOne(listOf(
                "cuter",
                "sweeter",
                "nicer",
                "better",
                "prettier"
        ))
    }

    private fun goodThings(): String {
        return pickOne(listOf(
                "sunshine",
                "rainbows",
                "cookies",
                "glitter",
                "unicorns",
                "kisses from a puppy",
                "good coffee",
                "every holiday all at once"
        ))
    }

    private fun goodEvents(): String {
        return pickOne(listOf(
                "you win a million dollars",
                "you only encounter green lights today",
                "you win at life",
                "the rain stops when you're outdoors and starts again when you go inside",
                "you make a new friend",
                "you get laid",
                "you get kissed by a puppy"
        ))
    }
}