package com.tappointment.ata.model

import com.tappointment.ata.entity.MainResult

interface RepositoryInterface {

    fun postSearch(queryParameters: HashMap<String, String>, completion: (MainResult?, error: String?) -> Unit)
}