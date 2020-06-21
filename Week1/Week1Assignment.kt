import javax.swing.Painter

// The purpose of this program is to create a simple BlackJame game
// @author Isabelle Dionisius

class Card {

    var pip:String  = ""
    var suit: Char = ' '

    // This function creates a deck for the Black Jack game
    fun createDeck():MutableSet<Pair<String,Char>> {
        val collectionPips = listOf<String>("4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace")
        //order: diamond,heart,club,spades
        val collectionSuits = listOf<Char>('\u2666', '\u2665', '\u2663', '\u2666')

        val cardSet = mutableSetOf<Pair<String,Char>>()

        for (item in collectionPips)
            for (i in collectionSuits)
                cardSet.add(Pair(item, i))
        return cardSet
    }

    //This function creates a hand with 2 cards
    fun dealHand(setCards:MutableSet<Pair<String,Char>> = createDeck()):MutableSet<Pair<String,Char>> {
        val firstCard = setCards.random()
        val secondCard = setCards.random()
        setCards.remove(firstCard)
        setCards.remove(secondCard)
        val deck:MutableSet<Pair<String,Char>> = mutableSetOf(firstCard,secondCard)
        return deck
    }

    //This function creates a result that shows the hand, the total and the result
    fun evaluateHand(deck:MutableSet<Pair<String,Char>> = dealHand()):String {
        var total = 0
        var (pip1:String, suit1:Char) = deck.elementAt(0)
        var (pip2:String, suit2:Char) = deck.elementAt(1)

        val numericValue = assignNumericValues(pip1)+ assignNumericValues(pip2)

        var message = "Your hand was: \n $pip1 $suit1 \n $pip2 $suit2 \n" +
                "Your total is $numericValue \n${checkTotal(numericValue)} "
        return message
    }

    // This function takes in one card and turns a facecard or an ace into a numeric value
    fun assignNumericValues(pip:String):Int {
        var numericValue = 0
        if(pip=="Jack"|| pip == "Queen" || pip == "King") {
            numericValue = 10
        } else if(pip == "Ace") {
            numericValue = 11
        } else {
            numericValue = pip.toInt()
        }
        return numericValue
    }

    // this function takes in the numeric values and calculates if the user won or lost
    fun checkTotal (numericValue:Int):String {
        var message = ""
        if (numericValue == 21)
            message = "You won"
        else
            message = "You lost"
        return message
    }
}

// The main function creates an object card of class Card and runs the functions
fun main () {
    val card = Card()
    println(card.evaluateHand())




}



