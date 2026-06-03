package hwr.oop.examples.template.core

enum class Card (private val card: CardDefinition) {

    COPPER(Copper()),
    ESTATE(Estate());

    companion object {
        fun fromName(name: String): Card? {
            return entries.firstOrNull { it.name == name }
        }
    }

    fun name() = card.name

    fun isAction(): Boolean {
        return card.types.contains(CardType.ACTION)
    }

    fun isTreasure(): Boolean {
        return card.types.contains(CardType.TREASURE)
    }

    fun play(player: Player, currentStats: Stats, state: GameState): PlayResult {
        val stats = currentStats.change(card.actions, card.buys, card.gold)
        val playerAfterDraw = player.draw(card.draw)
        val context = GameContext(playerAfterDraw.use(this), stats, state)
        return card.action(context)
    }

    fun cost() = card.cost

    fun types() = card.types

}