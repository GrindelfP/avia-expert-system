package to.grindelf.expertsystem.solver

import to.grindelf.expertsystem.domain.LogicalEntry
import to.grindelf.expertsystem.utils.JsonOperator
import to.grindelf.expertsystem.utils.Language

/**
 * Utility object for responding to user's entries.
 */
object Responder {

    private val rules: List<LogicalEntry> = JsonOperator.produceLogics(Language.ENGLISH)

    /**
     * Generates respond for user based on user's entries and logical rules.
     */
    fun respond(entry: String): String {
        var respond = ""
        rules.forEach { rule ->
            if (rule.condition == entry) {
                respond = rule.advice
            }
        }

        return respond
    }

}
