package com.kamikaze.firstkotlinprogram.databaseroomdb

//import androidx.lifecycle.*
//import kotlinx.coroutines.launch
//
//class NotesViewModel(private val respository :NotesRepositary):ViewModel() {
//    val allNotes:LiveData<List<Notes>> = respository.allnotes.asLiveData()
//    fun insert(notes: Notes) =viewModelScope.launch {
//        respository.insert(notes)
//    }
//}
//class NotesViewModelFactory(private val respository: NotesRepositary):ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(NotesViewModel::class.java)){
//            @Suppress("UNCHECKED_CAST")
//            return NotesViewModel(respository) as T
//        }
//throw IllegalArgumentException("Unknown view model") }}