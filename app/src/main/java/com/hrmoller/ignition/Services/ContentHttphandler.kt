package com.hrmoller.ignition.Services

import com.example.ignition.R
import com.hrmoller.ignition.DTOs.Content.ContentDTO
import com.hrmoller.ignition.DTOs.Content.CreateContentDTO
import com.hrmoller.ignition.DTOs.Content.UpdateContentDTO
import com.hrmoller.ignition.Models.Content
import com.hrmoller.ignition.Services.factories.ContentFactory
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class ContentHttphandler(private val httpClient: HttpClient, private val contentFactory: ContentFactory){

    private val contentList: MutableList<Content> = mutableListOf()
    private val stringBuilder: StringBuilder = StringBuilder()

    suspend fun getContents(): MutableList<Content> {

        val response: HttpResponse = httpClient.use {it.get { url("https://ascendance.hrmoller.com/api/contents") }}
        var obj = response.body<List<ContentDTO>>()
        for (item in obj){
            contentList.add(contentFactory.getContent(item))
        }
        return contentList;
    }

    public suspend fun updateContent(content: UpdateContentDTO): HttpStatusCode {
        val json = Json.encodeToString(content)
        val response: HttpResponse = httpClient.use { it.put(R.string.BaseURI.toString()){
            contentType(ContentType.Application.Json)
            setBody(json)
            }
        }
        return response.status
    }

    public suspend fun deleteContent(id: Int): HttpStatusCode {
        val response: HttpResponse = httpClient.use { it.delete(stringBuilder
            .append(R.string.BaseURI.toString())
            .append(id.toString()).toString())
        }
        return response.status
    }

    public suspend fun createContent(content: CreateContentDTO): HttpStatusCode {
        val json = Json.encodeToString(content)
        val response: HttpResponse = httpClient.use { it.post(R.string.BaseURI.toString()){
            contentType(ContentType.Application.Json)
            setBody(json)
            }
        }
        return response.status
    }
}