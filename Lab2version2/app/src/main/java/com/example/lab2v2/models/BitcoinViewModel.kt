package com.example.lab2v2.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab2v2.services.GetBitcoin
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BitcoinViewModel: ViewModel() {

    private lateinit var getBitcoinInterface: GetBitcoin

    private var _bitcoinHash = MutableLiveData<String>("None yet")
    val bitcoinHash : LiveData<String> = _bitcoinHash

    init {
        var retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:3003/bitstream.info/api/block/")
            .build()

        getBitcoinInterface = retrofit.create(GetBitcoin::class.java)
    }

    fun getOneBitcoin() {
        viewModelScope.launch {
            val bitcoin = getBitcoinInterface.getBitcoin().id
            Log.i("RFR", "< ${bitcoin.toString()} >")
            _bitcoinHash.value = bitcoin.toString()
        }
    }


}