package com.hrmoller.ignition.Services

import androidx.lifecycle.viewmodel.compose.viewModel
import com.hrmoller.ignition.Services.factories.ContentFactory
import com.hrmoller.ignition.ViewModels.ContentListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.content.ByteArrayContent
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val appModule = module {
    single<HttpClient> { HttpClient(Android){
        install(ContentNegotiation){
            json(Json{
                prettyPrint = true
                isLenient = true
            })
        }
    } }
    single<ContentFactory>{ContentFactory()}
    single<ContentHttphandler> {ContentHttphandler(get<HttpClient>(), get<ContentFactory>())}
    single<ContentDatahandler> { ContentDatahandler(get<ContentHttphandler>(), get<ContentFactory>()) }
    viewModel {ContentListViewModel(dataHandler = get<ContentDatahandler>())}
}