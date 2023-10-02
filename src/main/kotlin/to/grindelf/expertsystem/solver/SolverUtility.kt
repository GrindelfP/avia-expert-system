package to.grindelf.expertsystem.solver

import to.grindelf.expertsystem.domain.KnowledgeModelEntry
import to.grindelf.expertsystem.domain.Respond

object SolverUtility {

    /**
     * Completes respond to the user's entries.
     *
     * @param entries list of user's entries.
     *
     * @return respond to the user's entries.
     */
    fun solve(entries: List<String>): Respond = generateRespond(entries)


    /**
     * Generates respond for user based on user's entries.
     *
     * @param userProperties list of user's entries.
     * @return respond for user.
     */
    private fun generateRespond(entries: List<String>): Respond {
        var respond = ""
        entries.forEach { entry ->
            respond = respond.plus("\t - ").plus(Responder.respond(entry)).plus("\n")
        }

        return Respond(respond)
    }

    /**
     * Extract user properties' choices from user entries.
     *
     * @param entries list of user's entries.
     *
     * @return list of user properties' choices.
     */
    private fun extractUserPropertiesChoices(entries: List<KnowledgeModelEntry>): List<String> {
        val userPropertiesChoices: MutableList<String> = mutableListOf()
        entries.forEach { entry ->
            userPropertiesChoices.add(entry.property)
        }

        return userPropertiesChoices
    }
}
