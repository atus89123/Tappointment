package com.tappointment.ata.entity


data class Result (
    var subcategory_name: String,
    var distance_km: Double,
    var postalcode: String,
    var city: String,
    var address_line1: String,
    var address_line2: String,
    var fantasy_name: String,
    var picture: ArrayList<Picture>
)