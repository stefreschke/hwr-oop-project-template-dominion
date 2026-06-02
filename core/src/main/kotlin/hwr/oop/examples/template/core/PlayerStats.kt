package hwr.oop.examples.template.core

data class PlayerStats(
    val actions: Int,
    val purchases: Int,
    val money: Int
){
    fun change(actions: Int, purchases: Int, money: Int): PlayerStats {
        return PlayerStats(this.actions + actions, this.purchases + purchases, this.money + money)
    }
}