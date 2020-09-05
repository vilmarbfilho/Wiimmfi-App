package br.com.vlabs.domain.entity

sealed class Console(open val name: String) {
    data class NDS(override val name: String) : Console(name)
    data class WII(override val name: String) : Console(name)
    object UNKNOWN : Console("UNKNOWN")
}