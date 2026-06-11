package hwr.oop.examples.template.core

class NoActionException(card: Card) : Exception("expected card to be action but only got ${card.types()}")