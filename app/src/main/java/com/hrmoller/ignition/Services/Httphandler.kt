package com.hrmoller.ignition.Services

import com.example.ignition.R
import com.hrmoller.ignition.DTOs.Content.ContentDTO
import com.hrmoller.ignition.DTOs.Content.CreateContentDTO
import com.hrmoller.ignition.DTOs.Content.UpdateContentDTO
import com.hrmoller.ignition.Models.Content
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class Httphandler(private val httpClient: HttpClient){

    private val contentList: MutableList<Content> = mutableListOf()
    private val stringBuilder: StringBuilder = StringBuilder()
    suspend fun getContens(): MutableList<Content> {

        val response: HttpResponse = httpClient.get(R.string.BaseURI.toString())
        val obj = response.body<List<ContentDTO>>()
        for (item in obj){
            contentList.add(contentFactory.getContent(item))
        }
        return contentList;
    }

    public suspend fun updateContent(content: UpdateContentDTO): HttpStatusCode {
        val json = Json.encodeToString(content)
        val response: HttpResponse = httpClient.put(R.string.BaseURI.toString()){
            contentType(ContentType.Application.Json)
            setBody(json)
        }
        return response.status
    }

    public suspend fun deleteContent(id: Int): HttpStatusCode {
        val response: HttpResponse = httpClient.delete(stringBuilder
            .append(R.string.BaseURI.toString())
            .append(id.toString()).toString())
        return response.status
    }

    public suspend fun createContent(content: CreateContentDTO): HttpStatusCode {
        val json = Json.encodeToString(content)
        val response: HttpResponse = httpClient.post(R.string.BaseURI.toString()){
            contentType(ContentType.Application.Json)
            setBody(json)
        }
        return response.status
    }
}