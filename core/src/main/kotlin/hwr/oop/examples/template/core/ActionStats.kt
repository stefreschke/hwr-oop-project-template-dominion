package hwr.oop.examples.template.core

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ActionStats(private val actionStats: List<ActionStat>) {

    @OptIn(ExperimentalUuidApi::class)
    fun applyEffect(cardEffects: CardEffects) : ActionStats {
        val newList = actionStats.map { actionStat ->
            cardEffects.statWith(actionStat.identifier)
                ?.applyCardEffect(actionStat)
                ?: actionStat
        }

        return ActionStats(newList)
    }

    @OptIn(ExperimentalUuidApi::class)
    fun statWith(identifier: Uuid) : ActionStat{
        for(stat in actionStats) {
            if(stat.identifier == identifier) {
                return stat
            }
        }
        throw NoSuchElementException("No stat with identifier $identifier")
    }

}
