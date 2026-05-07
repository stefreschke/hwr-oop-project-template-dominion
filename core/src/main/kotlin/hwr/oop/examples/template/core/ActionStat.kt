package hwr.oop.examples.template.core

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
data class ActionStat(val value: Int, val identifier : Uuid) {
    constructor(value : Int) : this(value, Uuid.random())
    fun alter(value: Int) : ActionStat{
        return ActionStat(value, identifier)
    }
}