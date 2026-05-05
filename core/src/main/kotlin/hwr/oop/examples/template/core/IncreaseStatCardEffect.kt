package hwr.oop.examples.template.core

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid
@OptIn(ExperimentalUuidApi::class)
class IncreaseStatCardEffect(
    override val identifier: Uuid,
    private val value : Int
) : CardEffect{

    override fun applyCardEffect(actionStat: ActionStat): ActionStat {
        return actionStat.alter(actionStat.value + value)
    }
}
