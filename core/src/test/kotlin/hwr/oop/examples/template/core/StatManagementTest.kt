package hwr.oop.examples.template.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class StatManagementTest {

    @OptIn(ExperimentalUuidApi::class)
    @Test
    fun `executing card changes gameContext by increasing one action stat`(){
        //given
        val inputValue = 5
        val cardValue = 2
        val identifier = Uuid.random()
        val context = singleValueContext(inputValue, identifier)
        val card = singleValueCard(cardValue, identifier)
        //when
        val resultContext = card.execute(context)
        val resultStatValue = resultContext.stats().statWith(identifier).value
        //then
        assertThat(resultStatValue).isEqualTo(inputValue + cardValue)
    }

    @OptIn(ExperimentalUuidApi::class)
    fun singleValueContext(value: Int, id: Uuid): GameContext {
        val actionStat = ActionStat(value, id)
        val actionStats = ActionStats(listOf(actionStat))
        return GameContext(actionStats)
    }

    @OptIn(ExperimentalUuidApi::class)
    fun singleValueCard(value: Int, id: Uuid): ExtendedCard {
        val cardStat = IncreaseStatCardEffect(id, value)
        val cardEffects = CardEffects(listOf(cardStat))
        val base = BaseCard(cardEffects);
        return  ExampleCard(base)
    }

//    @OptIn(ExperimentalUuidApi::class)
//    @Test
//    fun `querying unregistered uuid on set method resourceWith throws exception`(){
//        val set = ResourceSetWrapper(2)
//        val resourceSet = set.resourceSet
//        val wrongId = Uuid.random()
//        assertThrows(NullPointerException::class.java) {
//            resourceSet.resourceWith(wrongId)
//        }
//    }
//
//    @Test
//    fun `method alter on action resource changes value`(){
//        //given
//        val resource = ActionResource(3)
//        val value = resource.value()
//        //when
//        val result = resource.alter(value + 1)
//        //then
//        assertThat(result.value()).isNotEqualTo(resource.value())
//    }
//
//    @OptIn(ExperimentalUuidApi::class)
//    @Test
//    fun `using method resourceWith in action resource set with uuid returns the exact instance`(){
//        //given
//        val set = ResourceSetWrapper(5)
//        //when
//        val resource = set.resourceSet.resourceWith(set.uuid)
//        val result = resource.value()
//        //then
//        assertThat(result).isEqualTo(set.inputValue)
//    }
//
//    @OptIn(ExperimentalUuidApi::class)
//    @Test
//    fun `using method alter in action resource set with uuid changes value of action resource with Uuid`(){
//        //given
//        val set = ResourceSetWrapper(4)
//        //when
//        val result = set.resourceSet.alter(set.uuid, set.inputValue + 1)
//        val element = result.resourceWith(set.uuid)
//        val outputValue = element.value()
//        //then
//        assertThat(outputValue).isNotEqualTo(set.inputValue)
//    }

}