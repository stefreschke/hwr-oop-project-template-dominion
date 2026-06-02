package hwr.oop.examples.template.core

class UnplayableCardException(card: Card) : Exception(card.unplayableErrorDescription())