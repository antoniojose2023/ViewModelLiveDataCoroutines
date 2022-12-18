package br.com.antoniojoseuchoa.viewmodellivedatacoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.data.RepositoryUrlImpl
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.EncurtedUrl
import br.com.antoniojoseuchoa.viewmodellivedatacoroutines.domain.RepositoryUrl
import kotlinx.coroutines.launch

class UrlViewModel(private val repositoryUrlImpl: RepositoryUrlImpl = RepositoryUrlImpl()): ViewModel() {

    private var _url: MutableLiveData<States> = MutableLiveData()
    val url: LiveData<States> = _url

    init {
        loaders()
    }

    fun loaders(){
        _url.value = States.Loader

        viewModelScope.launch {
            try {
                _url.value = States.Sucess(repositoryUrlImpl.getAll())
            }catch (ex: Exception){
                _url.value = States.Erro(ex.toString())
            }

        }
    }

    sealed class States{
       object Loader: States()
       class Sucess(val list: List<EncurtedUrl>): States()
       class Erro(val mensage: String): States()
    }

}