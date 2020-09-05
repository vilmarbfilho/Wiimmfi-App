package br.com.vlabs.domain.entity

data class Game(
    val console: Console,
    val name: String,
    val remark: String,
    val variants: String,
    val online: String
)