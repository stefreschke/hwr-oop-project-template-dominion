package hwr.oop.examples.template.core

class NoPendingChoiceException(playerID: String): Exception("not waiting for choice of player: $playerID")
