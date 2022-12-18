package br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain

interface RepositoryUrl {
     fun getAll(): List<EncurtedUrl>
}