package hwr.oop.examples.template.core

class NoSuchCardException(it: String): Exception("no card found for name: $it")
