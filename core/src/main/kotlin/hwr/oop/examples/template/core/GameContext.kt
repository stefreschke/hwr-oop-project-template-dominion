package hwr.oop.examples.template.core

data class GameContext(private val actionStats : ActionStats){

    fun stats() = actionStats
    fun applyCardStats(cardEffects : CardEffects) : GameContext{
        val result = cardEffects.addStatsTo(actionStats)
        return GameContext(result)
    }
}
