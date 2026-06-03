package hwr.oop.examples.template.core

class NoTreasureException(card: Card) : Exception("expected card to be treasure but only got ${card.types()}")
