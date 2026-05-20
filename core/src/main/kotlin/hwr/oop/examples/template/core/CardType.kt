package hwr.oop.examples.template.core


// Alle Typen von Karten ---- später mehrere Typen für eine Karte (z.B. Adlige)
enum class CardType(private val type: String) {
    ACTION("action"),
    TRESSURE("tressure"),
    POINTS("points")
}
