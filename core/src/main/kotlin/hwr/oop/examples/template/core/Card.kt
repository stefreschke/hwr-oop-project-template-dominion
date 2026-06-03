package hwr.oop.examples.template.core

enum class Card (private val card: CardDefinition) {

    COPPER(Copper()),
    ESTATE(Estate());

    fun name() = card.name

    fun isPlayable(): Boolean {
        return card.types.contains(CardType.ACTION) ||
                card.types.contains(CardType.TREASURE)
    }

    fun play(player: Player, currentStats: Stats, state: GameState): PlayResult {
        val stats = currentStats.change(card.actions, card.buys, card.gold)
        val playerAfterDraw = player.draw(card.draw)
        val context = GameContext(playerAfterDraw.use(this), stats, state)
        return card.action(context)
    }

    fun cost() = card.cost

    fun unplayableErrorDescription(): String {
        check( !(isPlayable()) ) { "unplayable error only exists for playable cards" }

        return "only cards of types \"action\" and \"treasure\" may be played, actual types only include: " + card.types
    }

}