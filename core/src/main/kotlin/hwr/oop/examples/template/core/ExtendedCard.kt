package hwr.oop.examples.template.core

abstract class ExtendedCard(private val base: BaseCard) {
    fun execute(context: GameContext): GameContext {
        val afterBase = base.execute(context)
        return customEffect(afterBase)
    }



    protected open fun customEffect(context: GameContext): GameContext = context
    override fun toString(): String {
        return "ExtendedCard(base=$base)"
    }
}