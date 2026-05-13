package hwr.oop.examples.template.core

import kotlinx.serialization.Serializable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Paths

class GameSaveTest {
    @Test
    fun `serialize Json from test class`() {
        val testClass = jsonTest("name", 4)
        val jsonObject = Json.encodeToString(jsonTest.serializer(), testClass)
        println(jsonObject)
        val string ="{\"name\":\"John\",\"age\":42}"
        val test = Json.decodeFromString<jsonTest>(string)
        println(test.name+", "+test.age)
    }
    @Test
    fun `save`(){
        val outputPath = Paths.get("output.txt")
        val initialContent = "Hello, World!\nThis is a new line of text.\n"
        Files.write(outputPath, initialContent.toByteArray())
    }

    @Serializable
    data class jsonTest(val name: String, val age: Int)
}
