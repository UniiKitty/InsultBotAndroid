package simez.com.insultbot

class InsultGenerator() {
    init {

    }

    fun generate(): String {
        return pickOne(listOf(
            "Get ${disease()} and ${die()}${youBlank()}",
            "I hope ${badThingHappens()}${youBlank()}"
//            "your \(Relative()) \(Pluralise(Hate())) you\(youBlank())",
//            "\(YouSmell()) like \(AnimalExcrement())",
//            "\(YouAre()) \(Article(Noun()))",
//            "\(YouAre()) \(Article(Adjective())) \(Noun())",
//            "\(YouAre()) \(Article(Noun())), \(Article(Adjective())) \(Noun())",
//            "\(YouAre()) \(Article(Noun())), and your \(Relative()) is \(Article(Noun()))",
//            "\(YouAre()) \(Article(Noun())), and your \(Relative()) is \(Article(Adjective())) \(Noun())",
//            "\(YouHave()) \(Article(Adjective())) \(SexAnatomy())",
//            "you \(Walk()) like \(Article(animal()))\(youBlank())",
//            "\(CertainDay()) you \(DoingSomethingEmbarrassing())\(MaybeWhileFamilyWatches())",
//            "your \(BodyParts()) are \(Ugly()), your \(BodyPart()) is \(Ugly()), and you smell like \(Article(SmellyNoun()))",
        )).capitalize().trim() + '.'
    }

    private fun pickOne(list: List<String>): String {
        return list.shuffled().take(1).first()
    }

    private fun article(text:String): String {
        if (isVowel(text.toCharArray().first())) {
            return "an $text"
        }

        if (text.startsWith("use") || text.startsWith("urin")) {
            return "a $text"
        }

        return "a $text"
    }

    private fun isVowel(char:Char): Boolean {
        return listOf('a','e','i','o','u').contains(char.toLowerCase())
    }

    private fun ingify(text: String): String {
        if (isVowel(text.last())) {
            return "${text.dropLast(1)}ing"
        }

        if (isVowel(text[text.length -2]) && isVowel(text[text.length - 3])) {
            return "${text}ing";
        }

        if (isVowel(text[text.length -2])) {
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
            return "${text.dropLast(1)} or";
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

    private fun disease(): String {
        return pickOne(listOf("AIDS", "smallpox", "leprosy", "malaria", "cholera"))
    }

    private fun die(): String {
        return pickOne(listOf(
            "die",
            "fall down a set of stairs",
            "run into a wall",
            "walk into oncoming traffic",
            "burn in a fire",
            "get eaten by ${article(animal())}",
            "die from ${disease()}"
        ))
    }

    private fun youBlank(): String {
        return pickOne(listOf(
            "",
            ", you ${noun()}",
            ", you ${adjective()} ${noun()}"
        ))
    }

    private fun youGet(): String {
        return pickOne(listOf("your ${relative()} gets", "you get"))
    }

    private fun relative(): String {
        return pickOne(listOf("brother", "sister", "father", "mother", "grandpa", "grandma", "dog", "cat", "boyfriend", "girlfriend"))
    }

    private fun animal(): String {
        return pickOne(listOf(
            "ape",
            "camel",
            "chicken",
            "chimpanzee",
            "chihuahua",
            "cow",
            "crocodile",
            "dog",
            "donkey",
            "elephant",
            "fish",
            "goat",
            "hippo",
            "horse",
            "llama",
            "monkey",
            "pig",
            "rat",
            "skunk"
        ))
    }

    private fun smallAnimal(): String {
        return pickOne(listOf("rat", "flea", "spider", "insect", "maggot"))
    }

    private fun smallObject():String {
        return pickOne(listOf(fruit(), smallAnimal()))
    }

    private fun adjective(): String {
        return pickOne(listOf(
            compoundAdjective(),
            singleWordAdjective(),
            "${singleWordAdjective()}, ${compoundAdjective()}"
        ))
    }

    private fun singleWordAdjective(): String {
        return pickOne(listOf(
            "bloody",
            "brain dead",
            "degenerate",
            "depraved",
            "despicable",
            "disgusting",
            "drooling",
            "fat",
            "festering",
            "filthy",
            "half witted",
            "insignificant",
            "insecure",
            "miserable",
            "pathetic",
            "rancid",
            "repulsive",
            "ridiculous",
            "ugly",
            "vulgar",
            "worthless"
        ))
    }

    private fun compoundAdjective(): String {
        return pickOne(listOf(
            "${penis()} sucking",
            "${sexAnatomy()} licking",
            "${fluid()} ${ingify(guzzle())}",
            "${feces()} ${ingify(eat())}",
            "${excrement()} stained",
            "${animal()} ${ingify(fuck())}",
            "${disease()} ridden",
            "${smallAnimal()} infested"
        ))
    }

    private fun noun(): String {
        return pickOne(listOf(
            anatomy(),
            fluidContainer(),
            "${smellyNoun()} ${food()}",
            "${sexAnatomy()} face",
            "${smellyNoun()} breath",
            "piece of ${feces()}",
            "piece of ${animal()} ${feces()}",
            "son of ${article(animal())}",
            buffoon(),
            "${fluid()} ${nounify(guzzle())}",
            "${feces()} ${nounify(eat())}",
            "${animal()} ${nounify(fuck())}",
            "${excrement()} stain",
            "${sexAnatomy()} monster",
            "slut",
            racist()
        ))
    }

    private fun fluid(): String {
        return pickOne(listOf(semen(), urine(), vomit(), "douche", "diarrhea"))
    }

    private fun container(): String {
        return pickOne(listOf("bag", "sack", "bucket", "bowl"))
    }

    private fun food():String {
        return pickOne(listOf("burger", "sandwich", "cake", "biscuit"))
    }

    private fun fruit():String {
        return pickOne(listOf("banana", "lemon", "mango", "cheese"))
    }

    private fun fluidContainer(): String {
        return pickOne(listOf("${fluid()} ${container()}", "${container()} of ${fluid()}"))
    }

    private fun eat(): String {
        return pickOne(listOf("eat", "lick", "sniff", "inhale"))
    }

    private fun fuck(): String {
        return pickOne(listOf("fist", "fuck", "hump", "molest", "violate", "penetrate", "abuse", "bang", "screw"))
    }

    private fun guzzle(): String {
        return pickOne(listOf("drink", "guzzle", "slurp"))
    }

    private fun buffoon(): String {
        return pickOne(listOf("moron", "idiot", "loser", "dummy", "fuckwit"))
    }

    private fun smellyNoun(): String {
        return pickOne(listOf(penis(), anus(), feces(), "fart"))
    }

    private fun excrement(): String {
        return pickOne(listOf(feces(), semen(), urine(), vomit(), "douche"))
    }

    private fun anatomy(): String {
        return pickOne(listOf(penis(),pubicHair(),anus(), "wart", "pimple", "testicle"))
    }

    private fun racist(): String {
        return pickOne(listOf("racist", "nazi", "communist", "hippie"))
    }

    private fun feces(): String {
        return pickOne(listOf("poop", "shit", "turd"))
    }

    private fun semen(): String {
        return pickOne(listOf("cum", "jizz", "semen"))
    }

    private fun urine(): String {
        return pickOne(listOf("piss", "urine"))
    }

    private fun hiccups(): String {
        return pickOne(listOf("hiccups", "sunburn", "bad breath", "frizzy hair", "a paper cut", "pink eye", "the runs", "food poisoning"))
    }

    private fun vomit(): String {
        return pickOne(listOf("puke", "vomit"))
    }

    private fun penis(): String {
        return pickOne(listOf("cock", "penis", "penis"))
    }

    private fun anus(): String {
        return pickOne(listOf("anus", "ass", "rectum", "butt", "asshole"))
    }

    private fun pubicHair(): String {
        return pickOne(listOf("pube", "pubic hair"))
    }

    private fun sexAnatomy(): String {
        return pickOne(listOf(penis(), anus()))
    }

    private fun raped(): String {
        return pickOne(listOf("raped", "eaten", "humped", "violated", "captured", "imprisoned", "enslaved", "tortured"))
    }

    private fun pack(): String {
        return pickOne(listOf("group", "family", "pack", "swarm"))
    }

    private fun crucified(): String {
        return pickOne(listOf("crucified", "crucified upside down"))
    }

    private fun hanged(): String {
        return pickOne(listOf("hanged", "hanged for ${ingify(fuck())} ${article(pluralise(animal()))}"))
    }

    private fun offCliff(): String {
        return pickOne(listOf("off a cliff", "down a well", "off a mountain", "into a volcano"))
    }

    private fun slapped(): String {
        return pickOne(listOf("slapped", "bitch slapped", "punched", "choked", "slapped silly", "spat on"))
    }

    private fun dirty(): String {
        return pickOne(listOf("dirty", "rusty", "AIDS infected", "filthy", "disgusting"))
    }

    private fun knife(): String {
        return pickOne(listOf("knife", "knife", "pitchfork", "fork", "syringe", "stick"))
    }

    private fun badThingHappens(): String {
        return pickOne(listOf(
            "it smells like ${article(smellyNoun())} on your ${niceDay()}",
            "${youGet()} ${disease()}",
            "${youGet()} ${hiccups()}",
            "${youGet()} ${raped()} by a ${pack()} of ${pluralise(animal())}",
            "you fall ${offCliff()} and die",
            "${youGet()} ${crucified()}",
            "${youGet()} ${hanged()}",
            "you walk in on your ${relative()} masturbating",
            "your ${relative()} catches you masturbating",
            "someone steals your car",
            "you get a nose bleed",
            "no one remembers your birthday",
            "${youGet()} ${slapped()}",
            "you spontaneously combust",
            "your ${relative()} has an affair with your ${relative()}",
            "${youGet()} stabbed with ${article(dirty())} ${knife()}",
            "you lose your job",
            "you marry the wrong person",
            "you fall into a ditch",
            "you miss the bus",
            "you drop and break your iPhone",
            "you shit your pants",
            "you get ${hiccups()}",
            "you stub your toe",
            "you lose your keys",
            "you get locked out of your house",
            "you step in ${animal()} ${feces()}",
            "you never find true love",
            "you get caught watching ${animal()} porn",
            "you get caught stuffing a ${smallAnimal()} down your pants"
        ))
    }

    private fun niceDay(): String {
        return pickOne(listOf("wedding day", "anniversary", "birthday"))
    }
}