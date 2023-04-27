package com.hrmoller.ignition.Services

import androidx.lifecycle.viewmodel.compose.viewModel
import com.hrmoller.ignition.ViewModels.ContentListViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.compose.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import io.ktor.client.*
import io.ktor.client.engine.cio.*

val appModule = module {
    single<HttpClient> {HttpClient(CIO)}
    single<Httphandler> {Httphandler(get())}
    single<Datahandler> { Datahandler(get()) }
    viewModel {ContentListViewModel(get())}
}