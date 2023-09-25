package to.grindelf.expertsystem.domain

/**
 * Class for storing property of object. It has two properties: content and mark.
 * Content holds all the verbose information the property represents, while
 * Mark is a number, scoring the content for formalization purposes.
 */
data class Property(
        val content: String,
        val mark: Int
) {
    /**
     * Overrides equals method. It compares two properties by their marks.
     */
    override fun equals(other: Any?): Boolean {
        var equals: Boolean = false
        if (other != null) {
            if (other is Property) {
                equals = this.mark == other.mark
            }
        }

        return equals
    }

    /**
     * Overrides hashCode method.
     */
    override fun hashCode(): Int {
        var result = content.hashCode()
        result = 31 * result + mark
        return result
    }

    /**
     * Overrides compareTo method. It compares two properties by their marks.
     */
    operator fun compareTo(other: Property): Int {
        return this.mark.compareTo(other.mark)
    }
}
