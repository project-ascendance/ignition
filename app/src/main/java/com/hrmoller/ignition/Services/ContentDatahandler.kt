package com.hrmoller.ignition.Services

import com.hrmoller.ignition.DTOs.Content.ContentDTO
import com.hrmoller.ignition.DTOs.Content.UpdateContentDTO
import com.hrmoller.ignition.Models.Content
import com.hrmoller.ignition.Services.factories.ContentFactory
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ContentDatahandler(private val httpHandler: ContentHttphandler, private val factory: ContentFactory){
    //TODO Set up use of room for local data storage

    private var contents : MutableList<Content> = mutableListOf()

    public fun getAllContents(): MutableList<Content> {

        fetchContents()
        return contents
    }

    public fun getContent(id: Int): Content? {

            try {
                return contents.single { c -> c.id == id}
            }
            catch (e : Exception){
                return null
            }

    }

    public fun updateContent(content: Content): HttpStatusCode {

        var res = runBlocking {
            httpHandler.updateContent(
                factory.getUpdateContentDTO(
                    content.id,
                    content.type,
                    content.title,
                    content.sites,
                    content.body,
                    content.image,
                    content.activeFrom,
                    content.activeTo,
                    content.creationTime,
                    content.author
                )
            )
        }
        fetchContents()

        if (res.value != 200){
            return res.description("Error updating content")
        }
        return res
    }

    public fun deleteContent(id: Int): HttpStatusCode {


        var res = runBlocking { httpHandler.deleteContent(id) }
        fetchContents()

        if (res.value != 200){
            return res.description("Error deleting content")
        }
        return res

    }

    public fun createContent(content: Content): HttpStatusCode {

        var res = runBlocking {
            httpHandler.createContent(
                factory.getCreateContentDTO(
                    content.type,
                    content.title,
                    content.sites,
                    content.body,
                    content.image,
                    content.activeFrom,
                    content.activeTo,
                    content.creationTime,
                    content.author))
        }
        fetchContents()

        if (res.value != 200){
            return res.description("Error creating content")
        }
        return res
    }

    private fun fetchContents(){
        runBlocking { contents = httpHandler.getContents()
        }
    }

}