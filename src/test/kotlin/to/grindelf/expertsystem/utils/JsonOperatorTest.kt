package to.grindelf.expertsystem.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JsonOperatorTest {

    @Test
    fun `GIVEN two english json files WHEN deserialized THEN deserializaion completed`() {
        val deserializedRules = JsonOperator.produceLogics(Language.ENGLISH)
        assertThat(deserializedRules).isNotEmpty
        val deserializedKnowledge = JsonOperator.produceKnowledgeModel()
        assertThat(deserializedKnowledge).isNotEmpty

        deserializedRules.forEach { rule ->
            assertThat(rule.condition).isNotEmpty
            assertThat(rule.advice).isNotEmpty
            println(rule)
        }

        deserializedKnowledge.forEach { knowledgeEntry ->
            assertThat(knowledgeEntry.objectId).isNotEmpty
            assertThat(knowledgeEntry.objectName).isNotEmpty
            assertThat(knowledgeEntry.propertyId).isNotEmpty
            assertThat(knowledgeEntry.property).isNotEmpty
            println(knowledgeEntry)
        }

    }

    @Test
    fun `GIVEN two russian json files WHEN deserialized THEN deserializaion completed`() {
        val deserializedRules = JsonOperator.produceLogics(Language.RUSSIAN)
        assertThat(deserializedRules).isNotEmpty
        val deserializedKnowledge = JsonOperator.produceKnowledgeModel(Language.RUSSIAN)
        assertThat(deserializedKnowledge).isNotEmpty

        deserializedRules.forEach { rule ->
            assertThat(rule.condition).isNotEmpty
            assertThat(rule.advice).isNotEmpty
            println(rule)
        }

        deserializedKnowledge.forEach { knowledgeEntry ->
            assertThat(knowledgeEntry.objectId).isNotEmpty
            assertThat(knowledgeEntry.objectName).isNotEmpty
            assertThat(knowledgeEntry.propertyId).isNotEmpty
            assertThat(knowledgeEntry.property).isNotEmpty
            println(knowledgeEntry)
        }

    }
}