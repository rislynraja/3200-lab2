package com.example.lab2v2.services

import com.example.lab2v2.models.BitcoinContainer
import retrofit2.http.GET

interface GetBitcoin { // BitcoinAPIServer
    @GET("00000000000000000000948e3e7249f4c456cbceb5322129b0d0a12dde47712c/") // originally bitcoinContainer
    suspend fun getBitcoin() : BitcoinContainer
}