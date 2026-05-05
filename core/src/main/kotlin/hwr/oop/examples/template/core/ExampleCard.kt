package hwr.oop.examples.template.core

class ExampleCard(base: BaseCard) : ExtendedCard(base) {
    override fun customEffect(context: GameContext): GameContext {
        return context
    }
}
