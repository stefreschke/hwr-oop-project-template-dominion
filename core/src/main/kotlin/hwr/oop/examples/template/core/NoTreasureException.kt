package hwr.oop.examples.template.core

class NoTreasureException(card: Card) : Exception("expected card to be only treasure but got ${card.types()}")
