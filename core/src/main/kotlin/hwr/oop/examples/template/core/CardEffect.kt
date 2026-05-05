package hwr.oop.examples.template.core

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
interface CardEffect{
    val identifier : Uuid
    fun applyCardEffect(actionStat: ActionStat) : ActionStat
}