package to.grindelf.expertsystem.solver

import org.junit.jupiter.api.Test

class SolverUtilityTest {

    private val userInput: List<String> = listOf(
        "A1", "A3", "A5", "A7", "A9", "A12", "A15", "A18", "A21", "A25"
    )

    @Test
    fun `GIVEN entries WHEN solve called CORRECT respond correctly`() {
        val respond = SolverUtility.solve(userInput)
        println(respond)
    }
}