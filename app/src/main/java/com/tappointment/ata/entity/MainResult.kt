package com.tappointment.ata.entity

import com.google.gson.annotations.SerializedName

data class MainResult (
    @SerializedName("results")
    var results: ArrayList<Result>,
    @SerializedName("result_num")
    var result_num: Int
)