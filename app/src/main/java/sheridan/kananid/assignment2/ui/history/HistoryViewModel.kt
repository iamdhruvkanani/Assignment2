package sheridan.kananid.assignment2.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sheridan.kananid.assignment2.database.Envelope
import sheridan.kananid.assignment2.database.EnvelopeDao
import sheridan.kananid.assignment2.database.EnvelopeDatabase

class HistoryViewModel(application: Application): AndroidViewModel(application){
    private val envelopeDao: EnvelopeDao =
        EnvelopeDatabase.getInstance(application).envelopeDao

    val history: LiveData<List<Envelope>> = envelopeDao.getAll()

    fun clear(){
        viewModelScope.launch {
            envelopeDao.deleteAll()
        }
    }
}