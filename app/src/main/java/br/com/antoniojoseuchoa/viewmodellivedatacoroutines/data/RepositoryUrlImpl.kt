package br.com.antoniojoseuchoa.viewmodellivedatacoroutines.data

import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.EncurtedUrl
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.RepositoryUrl

class RepositoryUrlImpl: RepositoryUrl {
    override fun getAll(): List<EncurtedUrl> {
        return listOf(
            EncurtedUrl("google.com.br", "google.com"),
            EncurtedUrl("google.com.br", "google.com"),
            EncurtedUrl("google.com.br", "google.com")
        )
    }
}