package simez.com.insultbot

class InsultGenerator() {
    init {

    }

    fun generate(): String {
        return pickOne(listOf(
                "I hope ${goodEvents()}",
                "You are ${youAre()}",
                "Your ${your()}",
                "You are ${youAre()} and your ${your()}",
                "You ${verb()} ${adjective()} than ${goodThings()}",
                "You have a big dick"
        )).capitalize().trim() + '.'
    }

    private fun pickOne(list: List<String>): String {
        return list.shuffled().take(1).first()
    }

/** grammar functions
 *
    private fun article(text: String): String {
        if (isVowel(text.toCharArray().first())) {
            return "an $text"
        }

        if (text.startsWith("use") || text.startsWith("urin")) {
            return "a $text"
        }

        return "a $text"
    }

    private fun isVowel(char: Char): Boolean {
        return listOf('a', 'e', 'i', 'o', 'u').contains(char.toLowerCase())
    }

    private fun ingify(text: String): String {
        if (isVowel(text.last())) {
            return "${text.dropLast(1)}ing"
        }

        if (isVowel(text[text.length - 2]) && isVowel(text[text.length - 3])) {
            return "${text}ing";
        }

        if (isVowel(text[text.length - 2])) {
            return "$text${text.last()}ing"
        }

        return "${text}ing";
    }

    private fun pluralise(text: String): String {
        if (text.endsWith("s")) {
            return text + "es";
        }
        if (text.endsWith("sh")) {
            return text + "es";
        }

        return text + "s";
    }

    private fun nounify(text: String): String {
        if (text.endsWith("ate")) {
            return "${text.dropLast(1)}or";
        }

        if (isVowel(text.last())) {
            return "${text}r";
        }

        if (isVowel(text[text.length - 2]) && isVowel(text[text.length - 3])) {
            return text + "er";
        }

        if (isVowel(text[text.length - 2])) {
            return text + text.last() + "er";
        }

        return "${text}er";
    }
*/
    private fun isAre(text:String): String {
        if (text.endsWith("s")) {
            return text + " are";
        }
        else {
            return text + " is";
        }
    }

    private fun youAre(): String {
        return pickOne(listOf(
                "${traits()}",
                "${adjective()} than ${goodThings()}",
                "${traits()} and you ${verb()} like ${goodThings()}"
        ))
    }

    private fun your(): String {
        return pickOne(listOf(
                "${relative()} is ${youAre()}",
                "${isAre(possession())} better than ${goodThings()}"
        ))
    }

    private fun idiomOne(): String {
        return pickOne(listOf(
                "bucket",
                "cloud",
                "shower",
                "meadow",
                "bed"
        ))
    }

    private fun idiomTwo(): String {
        return pickOne(listOf(
                "sunshine",
                "puppies",
                "icecream",
                "kittens",
                "bunnies",
                "newborn puppies",
                "happiness",
                "cookies",
                "unicorns"
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
                "laugh"
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
                "every holiday all at once",
                "a ${idiomOne()} of ${idiomTwo()}",
                "a ${idiomOne()} of ${idiomTwo()}",
                "a ${idiomOne()} of ${idiomTwo()}"
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