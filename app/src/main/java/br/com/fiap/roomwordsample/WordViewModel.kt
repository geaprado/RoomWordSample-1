package br.com.fiap.roomwordsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.fiap.roomwordsample.dao.WordDao
import br.com.fiap.roomwordsample.dao.WordRoomDatabase
import br.com.fiap.roomwordsample.model.Word
import br.com.fiap.roomwordsample.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application,
                    val wordRepository: WordRepository) : AndroidViewModel(application) {

    val allWords: LiveData<List<Word>> = wordRepository.allWords

    /*
    init {
        //val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allWords
    }*/

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        wordRepository.insert(word)
    }
}