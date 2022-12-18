package br.com.antoniojoseuchoa.viewmodellivedatacoroutines.data

import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.EncurtedUrl
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.RepositoryUrl
import kotlinx.coroutines.delay

class RepositoryUrlImpl: RepositoryUrl {
    override suspend fun getAll(): List<EncurtedUrl> {
        delay(2000)
        throw Exception("Erro de requisição")

        return listOf(
            EncurtedUrl("google.com.br", "google.com"),
            EncurtedUrl("google.com.br", "google.com"),
            EncurtedUrl("google.com.br", "google.com")
        )
    }
}