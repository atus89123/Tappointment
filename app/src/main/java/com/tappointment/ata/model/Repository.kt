package com.tappointment.ata.model

import com.tappointment.ata.entity.MainResult
import com.tappointment.ata.entity.PostObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val apiDefinition: APIDefinition) : RepositoryInterface {

    override fun postSearch(queryParameters: HashMap<String, String>, completion: (MainResult?, error: String?) -> Unit) {
        apiDefinition.postSearch(queryParameters).enqueue(object : Callback<MainResult> {
            override fun onResponse(call: Call<MainResult>, response: Response<MainResult>) {
                if (response.code() == 200) {
                    var mainResult = response.body()
                    completion(mainResult, null)
                } else {
                    completion(null, response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<MainResult>, t: Throwable) {
                completion(null, "error")
            }
        })
    }
}