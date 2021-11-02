package com.neo.daggerroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.neo.daggerroom.database.UserDao
import com.neo.daggerroom.database.UserEntity
import javax.inject.Inject


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var userDao: UserDao

    lateinit var allUserList:MutableLiveData<List<UserEntity>>

    init {
        (application as MyApplication).getAppComponent().inject(this)
        allUserList = MutableLiveData()
        getAllRecords()
    }

    // to get access to liveData
    fun getRecordsObserver(): MutableLiveData<List<UserEntity>>{
        return allUserList
    }

    private fun getAllRecords(){
        val list = userDao.getAllRecordsFromDb()
        allUserList.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity){
        userDao.insertRecord(userEntity)
        getAllRecords()
    }

}