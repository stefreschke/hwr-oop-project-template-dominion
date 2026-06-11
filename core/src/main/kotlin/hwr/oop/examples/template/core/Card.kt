package hwr.oop.examples.template.core

enum class Card (private val card: CardDefinition, private val apiValue: String) {

    COPPER(Copper(), "copper"),
    ESTATE(Estate(), "estate"),;

    companion object {
        private val apiValues = entries.associateBy(Card::apiValue)

        fun byName(name: String): Card {
            return apiValues[name]?: throw NoSuchCardException(name)
        }
    }

    fun stringName() = card.name

    fun isAction(): Boolean {
        return card.types.contains(CardType.ACTION)
    }

    fun isTreasure(): Boolean {
        return card.types.contains(CardType.TREASURE)
    }

    fun play(player: Player, currentStats: Stats, state: BoardState): PlayResult {
        val stats = currentStats.change(card.actions, card.buys, card.gold)
        val playerAfterDraw = player.draw(card.draw)
        val context = GameContext(ActivePlayer(playerAfterDraw.use(this), stats), state)
        return card.beginAction(context)
    }

    fun resume(context: GameContext, choices: Map<String, List<AnsweredChoice>>): PlayResult.Complete {
        return card.endAction(context, choices)
    }

    fun cost() = card.cost
    fun types() = card.types
}