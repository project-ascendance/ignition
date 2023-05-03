package com.hrmoller.ignition.Services.factories

import com.hrmoller.ignition.DTOs.Content.ContentDTO
import com.hrmoller.ignition.DTOs.Content.CreateContentDTO
import com.hrmoller.ignition.DTOs.Content.UpdateContentDTO
import com.hrmoller.ignition.Models.Content
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ContentFactory {

    public fun getContent(dto: ContentDTO): Content{
        return Content().apply {id = dto.id; title = dto.title; sites = dto.sites;
                                    body = dto.body; image = dto.image;
                                    activeFrom = dto.startDate;
                                    activeTo = dto.endDate; }
    }

    public fun getCreateContentDTO(type: String,
                                   title: String,
                                   sites: List<String>,
                                   body: String,
                                   image: String?,
                                   activeFrom: String,
                                   activeTo: String,
                                   creationTime: String,
                                   author: String): CreateContentDTO{

        return CreateContentDTO(type, title, sites, body, image, activeFrom,
                                    activeTo, creationTime, author)
    }
    public fun getUpdateContentDTO(id : Int,
                                   type: String,
                                   title: String,
                                   sites: List<String>,
                                   body: String,
                                   image: String?,
                                   activeFrom: String,
                                   activeTo: String,
                                   creationTime: String,
                                   author: String): UpdateContentDTO{

        return UpdateContentDTO(id, type, title, sites, body, image, activeFrom,
            activeTo, creationTime, author)
    }
    public fun getContentDTO(id : Int,
                             type: String,
                             title: String,
                             sites: List<String>,
                             body: String,
                             image: String?,
                             activeFrom: String,
                             activeTo: String,
                             ): ContentDTO{

        return ContentDTO(id, type, title, sites, body, image, activeFrom, activeTo)
    }
}