package simez.com.insultbot

class InsultGenerator() {
    init {

    }

    fun generate(): String {
        return pickOne(listOf(
            "Get ${disease()} and ${die()}${youBlank()}",
            "I hope ${badThingHappens()}${youBlank()}",
            "Your ${relative()} ${pluralise(hate())} you${youBlank()}",
            "${youSmell()} like ${animalExcrement()}",
            "${youAre()} ${article(noun())}",
            "${youAre()} ${article(adjective())} ${noun()}",
            "${youAre()} ${article(noun())}, ${article(adjective())} ${noun()}",
            "${youAre()} ${article(noun())}, and your ${relative()} is ${article(noun())}",
            "${youAre()} ${article(noun())}, and your ${relative()} is ${article(adjective())} ${noun()}",
            "${youHave()} ${article(adjective())} ${sexAnatomy()}",
            "you ${walk()} like ${article(animal())}${youBlank()}",
            "${certainDay()} you ${doingSomethingEmbarrassing()}${maybeWhileFamilyWatches()}",
            "your ${bodyParts()} are ${ugly()}, your ${bodyPart()} is ${ugly()}, and you smell like ${article(smellyNoun())}"
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

    private fun youAre(): String {
        return pickOne(listOf("you are", "your ${relative()} is"))
    }

    private fun youHave(): String {
        return pickOne(listOf("you have", "your ${relative()} has"))
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

    private fun animalExcrement(): String {
        return pickOne(listOf(
            "${animal()} ${excrement()}",
            "fresh ${animal()} ${excrement()}",
            "a piece of ${animal()} ${feces()}",
            "a fresh piece of ${animal()} ${feces()}"
        ))
    }

    private fun bodyPart(): String {
        return pickOne(listOf("face", "nose", "head", "beard", "skin", "hair"))
    }

    private fun bodyParts(): String {
        return pickOne(listOf("ears", "eyes", "arms", "legs", "teeth", "lips"))
    }

    private fun ugly(): String {
        return pickOne(listOf("atrocious", "vomit inducing", "disgusting", "deformed", "ugly", "gross", "weird"))
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

    private fun fecesVerb(): String {
        return pickOne(listOf("poop", "shit"))
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

    private fun hate(): String {
        return pickOne(listOf("hate", "despise", "detest", "fucking hate", "resent"))
    }

    private fun walk(): String {
        return pickOne(listOf("walk", "smell", "look", "sound", "laugh"))
    }

    private fun doingSomethingEmbarrassing(): String {
        return pickOne(listOf(
            "${fecesVerb()} on ${pluralise(animal())}",
            "sniff ${article(smellyNoun())}",
            "bathe in ${article(container())} of ${fluid()}",
            "drink ${animal()} ${urine()}",
            "eat ${animal()} ${feces()}",
            "masturbate to ${animal()} porn"
        ))
    }

    private fun maybeWhileFamilyWatches(): String {
        return pickOne(listOf("", " while your ${relative()} ${watches()}"))
    }

    private fun watches(): String {
        return pickOne(listOf("watches", "films it", "masturbates in the corner", "looks on approvingly", "joins in"))
    }

    private fun certainDay(): String {
        val onDate = pickOne(listOf(
            "Mondays",
            "Tuesdays",
            "Wednesdays",
            "Thursdays",
            "Fridays",
            "Saturdays",
            "Sundays",
            "Christmas",
            "Christmas Eve",
            "New Years Eve",
            "Halloween",
            "Valentine's Day"
        ))

        val onceDate = pickOne(listOf("day", "month", "year"))

        return pickOne(listOf("on $onDate", "once a $onceDate"))
    }

    private fun knife(): String {
        return pickOne(listOf("knife", "knife", "pitchfork", "fork", "syringe", "stick"))
    }

    private fun youSmell(): String {
        return pickOne(listOf("you smell", "your ${relative()} smells", "your breath smells", "your ${sexAnatomy()} smells"))
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
            "you drop and break your phone",
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