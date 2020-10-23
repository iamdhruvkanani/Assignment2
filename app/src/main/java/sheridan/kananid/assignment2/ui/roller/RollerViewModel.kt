package sheridan.kananid.assignment2.ui.roller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sheridan.kananid.assignment2.database.Envelope
import sheridan.kananid.assignment2.database.EnvelopeDao
import sheridan.kananid.assignment2.database.EnvelopeDatabase


class RollerViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    private val _envelopeId = MutableLiveData<Long?>().apply{
        value = null
    }

    val envelopeId: LiveData<Long?> = _envelopeId

    private val envelopeDao: EnvelopeDao =
        EnvelopeDatabase.getInstance(application).envelopeDao

    fun send(envelope: Envelope){
        viewModelScope.launch {
            _envelopeId.value = envelopeDao.insert(envelope)
        }
    }

    fun reset(){
        _envelopeId.value = null
    }
}