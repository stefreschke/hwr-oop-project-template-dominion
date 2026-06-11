package hwr.oop.examples.template.core

data class PendingChoice(private val minOpt: Int, private val maxOpt: Int){
    fun verify(answer: AnsweredChoice) {
        if(!wrongSize(answer.optCount())){
            throw OptionCountException(answer.optCount(), minOpt, maxOpt)
        }
    }

    private fun wrongSize(optCount: Int): Boolean {
        return optCount !in minOpt..maxOpt
    }

    private class OptionCountException(val actual: Int, val min: Int, val max: Int): Exception("requiring $min - $max but got $actual")

}
