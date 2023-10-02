package to.grindelf.expertsystem.solver

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import to.grindelf.expertsystem.domain.LogicalEntry
import to.grindelf.expertsystem.utils.JsonOperator
import to.grindelf.expertsystem.utils.Language

class ResponderTest {

    @Test
    fun `GIVEN entry WHEN respond called CORRECT respond is shown`() {
        val rules: List<LogicalEntry> = JsonOperator.produceLogics(Language.ENGLISH)
        val entries: List<String> = listOf("A1", "A2", "A3", "A4", "A5", "A6",
            "A7", "A8", "A9", "A10", "A11", "A12", "A13", "A14",
            "A15", "A16", "A17", "A18", "A19", "A20", "A21", "A22", "A23", "A24",
            "A25", "A26")

        entries.forEach { entry ->
            val respond = Responder.respond(entry)
            rules.forEach { rule ->
                if (rule.condition == entry) {
                    assertThat(respond).isEqualTo(rule.advice)
                }
            }
        }

    }
}