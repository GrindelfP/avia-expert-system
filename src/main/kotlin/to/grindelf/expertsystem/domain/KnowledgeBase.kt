package to.grindelf.expertsystem.domain

import to.grindelf.expertsystem.utils.JsonOperator
import to.grindelf.expertsystem.utils.Language

interface Initiatable {

    /**
     * Initiates knowledge model based on language.
     */
    fun <T> initiate(language: Language, producer: (language: Language) -> List<T>): List<T> = producer(language)
}

/**
 * Class for representing knowledge model. When instantiated with necessary language
 * it produces knowledge model and stores it.
 */
class KnowledgeModel(
    private val language: Language
) : Initiatable {

    val knowledgeModel: List<KnowledgeModelEntry> = initiate(language, JsonOperator::produceKnowledgeModel)
}

class LogicalRules(
    private val language: Language
) : Initiatable {

    val logicalRules: List<LogicalEntry> = initiate(language, JsonOperator::produceLogics)
}

/**
 * Data class for representing knowledge base entries.
 */
data class KnowledgeModelEntry(
    val objectId: String,
    val objectName: String,
    val propertyId: String,
    val property: String
)

/**
 * Data class for representing logical entries.
 */
data class LogicalEntry(
    val condition: String,
    val advice: String
)
