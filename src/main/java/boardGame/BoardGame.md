The reason I used `Composition` instant of `Aggregation` here was because the lifecycle stages of `BoardGame` in the code shows the classes, `Die`, `CardDeck`, `Card`, and `CradPlayer`, are built in the constructors.
Which means they will "die" when lifecycle of `BoardGame` died.

I used aggregation to describe `Card` and `CardPlayer` because the Card, that the Player has, comes from the function `getCard(Card)` , which is if lifecycle of `CardPlayer` died, the `Card` is still “being alive”.

```mermaid
classDiagram
    BoardGame "2" *-- "1" Die
    BoardGame <|-- CardGame
    Player <|-- CardPlayer
    CardGame "1..1" *-- "1..1" CardDeck
%%    CardGame <.. Card
    CardGame "0..*"*--"1..1" CardPlayer
    CardPlayer "0..*"o--"1..1" Card
    CardDeck "52"*--"1" Card
    Player "1..1"..>"1..1" Color
    class BoardGame {
        -NUMBER_OF_DICE: int =2
        -DICE_SIDES: int = 6
        #players: Player[]
        -dice: Die[]
        #turnNumber: int
        #BoardGame()
        +BoardGame(numberOfPlayers: int)
        #assignTurns() void
        +rollDice() int
        +nextTurn() void
    }
    class Card {
        -number: int
        -suit: string
        +Card(number: int, suit: string)
        +getNumber() int
        +getSuit() string
        +toString() string
    }
    class CardDeck {
        +TOTAL_CARDS: int = 52$
        -cards: Card[]
        -nextCard: int
        +CardDeck()
        +draw() Card
        +reshffle() void
    }
    class CardGame {
        -deck: CardDeck
        +CardGame()
        +currentPlayerDrawCard() void
        +dealCards(number: int) void
        +drawCard() Card
    }
    class CardPlayer {
        -hand: ArrayList~Card~
        +CardPlayer(color: string)
        +getCard(newCard: Card) void
        +loseCard(card: Card) void
        +printHand() void
    }
    class Color {
        -colorIndex: string$
        -colors: string[]$
        -Color()
        +getNextColor() string$
    }
    class Die {
        +sides: int
        +rand: Random
        +roll() int
        +checkSides() int
    }
    class Player {
        #color: string
        #turnOrder: int
        #points: int
        +Player(playerColor: string)
        +Player(playerColor: string, turnOrder: int)
        +setTurnOrder(position: int) void
        +getTurnOrder() int
        +checkPoints() int
        +gainPoints(pointsGained: int) void
        +losePoints(pointsLost: int) void
    }
```