package to.grindelf.expertsystem.utils

class EmptyJsonStringException : Exception() {
    override val message: String
        get() = "Json string is empty."
}