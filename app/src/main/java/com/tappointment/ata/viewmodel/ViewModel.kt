package com.tappointment.ata.viewmodel

import android.arch.lifecycle.ViewModel
import com.tappointment.ata.entity.MainResult
import com.tappointment.ata.model.RepositoryFactory

class ViewModel: ViewModel() {

    fun postSearch(completion: (MainResult?, error: String?) -> Unit){
        val queryParameters = HashMap<String, String>()
        queryParameters["action"] = "search"
        queryParameters["api_version"] = "3"
        queryParameters["limit"] = "2"
        queryParameters["page"] = "0"
        queryParameters["order"] = "distance"
        queryParameters["center"] = "{\"lat\":47.515134,\"lng\":19.077737}"

        RepositoryFactory.getRepository().postSearch(queryParameters) { mainResult, error ->
            if (error == null) {
                completion(mainResult, null)
            } else {
                completion(null, error)
            }
        }
    }
}