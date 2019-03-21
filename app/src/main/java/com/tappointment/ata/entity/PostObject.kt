package com.tappointment.ata.entity

data class PostObject (
    var action: String = "search",
    var api_version: String = "3",
    var limit: String = "2",
    var page: String = "0",
    var order: String = "distance",
    var center: String = "{“lat”:47.515134,”lng”:19.077737}"
)