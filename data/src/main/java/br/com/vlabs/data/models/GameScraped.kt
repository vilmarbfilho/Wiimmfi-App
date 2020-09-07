package br.com.vlabs.data.models

data class GameScraped(
    val id: String,
    val type: String,
    val name: String,
    val remark: String,
    val variants: String,
    val online: String
)