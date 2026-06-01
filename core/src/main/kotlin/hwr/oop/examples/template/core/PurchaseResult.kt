package hwr.oop.examples.template.core

sealed interface PurchaseResult {
    data class Success(val market: Market, val player: PlayerTurn): PurchaseResult
    data class Failure(val reason: String): PurchaseResult
}