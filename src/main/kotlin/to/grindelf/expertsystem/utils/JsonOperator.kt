package to.grindelf.expertsystem.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import to.grindelf.expertsystem.domain.KnowledgeModelEntry
import to.grindelf.expertsystem.domain.LogicalEntry

object JsonOperator {

    private const val KNOWLEDGE_MODEL_ENG_PATH = "/json/knowledge_model_eng.json"
    private const val LOGICAL_RULES_ENG_PATH = "/json/logical_rules_eng.json"
    private const val KNOWLEDGE_MODEL_RU_PATH = "/json/knowledge_model_ru.json"
    private const val LOGICAL_RULES_RU_PATH = "/json/logical_rules_ru.json"

    private val deserializer = objectMapper()

    /**
     * Converts .json string into List of LogicalEntry.
     *
     * @return List of LogicalEntry.
     */
    fun produceLogics(language: Language = Language.ENGLISH): List<LogicalEntry> {
        val jsonMode = when (language) {
            Language.ENGLISH -> JsonMode.LOGICAL_ENGLISH
            Language.RUSSIAN -> JsonMode.LOGICAL_RUSSIAN
        }
        val jsonString = jsonStringChecked(jsonMode)

        return deserializer.readValue<List<LogicalEntry>>(jsonString)
    }


    /**
     * Converts .json string into List of KnowledgeBaseEntry.
     *
     * @return List of KnowledgeBaseEntry.
     */
    fun produceKnowledgeModel(language: Language = Language.ENGLISH): List<KnowledgeModelEntry> {
        val jsonMode = when (language) {
            Language.ENGLISH -> JsonMode.KNOWLEDGE_ENGLISH
            Language.RUSSIAN -> JsonMode.KNOWLEDGE_RUSSIAN
        }
        val jsonString = jsonStringChecked(jsonMode)

        return deserializer.readValue<List<KnowledgeModelEntry>>(jsonString)
    }

    /**
     * An instance of a [ObjectMapper] with registered [kotlinModule()].
     */
    private fun objectMapper(): ObjectMapper = ObjectMapper().registerModule(kotlinModule())

    /**
     * Checks if .json-string in not null.
     *
     * @return .json file as a null-safe string.
     * @throws
     */
    private fun jsonStringChecked(mode: JsonMode): String = readJsonFileAsString(mode)
        ?: throw EmptyJsonStringException()


    /**
     * Reads .json file containing logical rules and returns it as a string.
     *
     * @return .json file as a null-possible string.
     */
    private fun readJsonFileAsString(mode: JsonMode): String? = when(mode) {
        JsonMode.KNOWLEDGE_ENGLISH -> this::class.java.getResource(KNOWLEDGE_MODEL_ENG_PATH)?.readText()
        JsonMode.LOGICAL_ENGLISH -> this::class.java.getResource(LOGICAL_RULES_ENG_PATH)?.readText()
        JsonMode.KNOWLEDGE_RUSSIAN -> this::class.java.getResource(KNOWLEDGE_MODEL_RU_PATH)?.readText()
        JsonMode.LOGICAL_RUSSIAN -> this::class.java.getResource(LOGICAL_RULES_RU_PATH)?.readText()
    }
}

/**
 * Mode of [JsonOperator] actions. It can be either LOGICAL or KNOWLEDGE.
 * Logical mode is used for reading logical rules from logical_rules_eng.json file.
 * Knowledge mode is used for reading knowledge model from knowledge_model_eng.json file.
 * Also, the language of the file can be determined either ENGLISH or RUSSIAN.
 *
 * @author GrindelfP, Shisha
 */
enum class JsonMode {
    LOGICAL_ENGLISH, LOGICAL_RUSSIAN,
    KNOWLEDGE_ENGLISH, KNOWLEDGE_RUSSIAN
}
