package hwr.oop.examples.template.core

class CardNotInHandException(card: Card): Exception("card ${card.stringName()} not in hand")