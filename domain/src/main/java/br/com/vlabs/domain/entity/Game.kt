package br.com.vlabs.domain.entity

data class Game(
    val id: String,
    val type: String,
    val name: String,
    val remark: String,
    val variants: String,
    val online: String
)