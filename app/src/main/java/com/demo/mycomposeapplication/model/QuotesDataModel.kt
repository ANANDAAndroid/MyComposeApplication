package com.demo.mycomposeapplication.model

class QuotesDataModel {
    data class Response(
        val quotes: List<Quote>
    )

    data class Quote(
        val author: String,
        val text: String
    )
}