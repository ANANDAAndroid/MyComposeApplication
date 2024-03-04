package com.demo.mycomposeapplication

class QuotesDataModel {
    data class Response(
        val quotes: List<Quote>
    )

    data class Quote(
        val author: String,
        val text: String
    )
}