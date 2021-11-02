package com.neo.daggerroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.neo.daggerroom.database.UserEntity
import com.neo.daggerroom.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    val mViewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)

        initViewModel()

        mBinding.saveButton.setOnClickListener {
            val user = UserEntity(name = mBinding.enterDescriptionEditText.text.toString())
            mViewModel.insertRecord(user)
            mBinding.resultTextView.text = ""
        }

    }

    private fun initViewModel(){
        mViewModel.getRecordsObserver().observe(this,
            {
                mBinding.resultTextView.text = ""
                it.forEach {
                  mBinding.resultTextView.append(it.name + "\n")
                }
            })
    }
}