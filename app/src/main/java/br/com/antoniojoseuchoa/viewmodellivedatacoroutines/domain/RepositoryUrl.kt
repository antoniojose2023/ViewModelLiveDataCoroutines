package br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain

interface RepositoryUrl {
     suspend fun getAll(): List<EncurtedUrl>
}