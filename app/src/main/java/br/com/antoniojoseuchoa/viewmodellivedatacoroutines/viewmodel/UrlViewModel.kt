package br.com.antoniojoseuchoa.viewmodellivedatacoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.data.RepositoryUrlImpl
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.EncurtedUrl
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.RepositoryUrl

class UrlViewModel(private val repositoryUrlImpl: RepositoryUrlImpl = RepositoryUrlImpl()): ViewModel() {

    private var _url: MutableLiveData<List<EncurtedUrl>> = MutableLiveData()
    val url: LiveData<List<EncurtedUrl>> = _url

    init {
        loaders()
    }

    fun loaders(){
        _url.value = repositoryUrlImpl.getAll()
    }

}