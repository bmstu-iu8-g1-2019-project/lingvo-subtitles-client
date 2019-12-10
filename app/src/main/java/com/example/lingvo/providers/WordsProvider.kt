package com.example.lingvo.providers

import com.example.lingvo.models.Card
import com.example.lingvo.models.SearchEntry
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.authentication
import com.github.kittinunf.fuel.json.responseJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.lang.reflect.Type


class WordsProvider {

    private val url = "http://10.0.2.2:5000"

    private val searchEntryCollectionType: Type = object : TypeToken<List<SearchEntry>>() {
    }.type

    private val cardCollectionType: Type = object : TypeToken<List<Card>>() {
    }.type

    fun search(text: String): List<SearchEntry> {
        val jsonArray = Fuel.post("$url/search", listOf("query" to text))
            .authentication()
            .basic("SampleUser", "SamplePassword")
            .responseJson()
            .third.get().array().toString()
        return Gson().fromJson<List<SearchEntry>>(jsonArray, searchEntryCollectionType)
    }

    fun getTest(entry: String): List<Card> {
        val jsonArray = Fuel.post("$url/parse", listOf("query" to entry))
            .authentication()
            .basic("SampleUser", "SamplePassword")
            .responseJson()
            .third.get().obj()["cards"]
            .let { it as JSONArray }
            .toString()
        return Gson().fromJson<List<Card>>(jsonArray, cardCollectionType)
    }
}