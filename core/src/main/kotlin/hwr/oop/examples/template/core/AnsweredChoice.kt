package hwr.oop.examples.template.core

data class AnsweredChoice(val playerID: String, val options: List<Int>){
    fun optCount() = options.size
}
