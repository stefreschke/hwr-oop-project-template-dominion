package hwr.oop.examples.template.core

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class CardEffects(private val effects : List<CardEffect>) {

    @OptIn(ExperimentalUuidApi::class)
    fun addStatsTo(actionStats : ActionStats) : ActionStats{
        return actionStats.applyEffect(this)
    }

    @OptIn(ExperimentalUuidApi::class)
    fun statWith(identifier: Uuid) : CardEffect? {
        for (stat in effects){
            if(stat.identifier == identifier){
                return stat
            }
        }

        return null
    }

}
