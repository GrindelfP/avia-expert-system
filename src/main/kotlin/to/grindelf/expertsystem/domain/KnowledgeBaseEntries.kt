package to.grindelf.expertsystem.domain

/**
 * Data class for representing knowledge base entries.
 */
data class KnowledgeBaseEntries(
    val objectId: String,
    val objectName: String,
    val property: String
)

/**
 * Data class for representing logical entries.
 */
data class LogicalEntry(
    val condition: String,
    val conclusion: String
)
