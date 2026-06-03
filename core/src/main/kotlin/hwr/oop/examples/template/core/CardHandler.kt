package hwr.oop.examples.template.core

object CardHandler {

    fun cardsByNames(names: List<String>): List<Card> {
        return names.map { Card.fromName(it)?: throw NoSuchCardException(it) }
    }

}