package hwr.oop.examples.template.core

fun requireAction(
    card: Card
) {
    if (!card.isAction()) throw NoActionException(card)
}

fun requireTreasure(
    card: Card
) {
    if (!card.isTreasure()) throw NoTreasureException(card)
}

fun requireGameRunning(
    status: GameStatus
){
    if(status !is GameStatus.Running) throw UnresolvedChoiceException()
}