package com.tappointment.ata.model

import com.tappointment.ata.entity.MainResult
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface APIDefinition {

    /*@POST("/mobile/m_search.php")
    fun postSearch(@Query("action") queryParameter1: String = "search",
                   @Query("api_version") queryParameter2: String = "3",
                   @Query("limit") queryParameter3: String = "2",
                   @Query("page") queryParameter4: String = "0",
                   @Query("order") queryParameter5: String = "distance",
                   @Query("center") queryParameter6: String = "{“lat”:47.515134,”lng”:19.077737}") : Call<MainResult>*/

    @POST("/mobile/m_search.php")
    fun postSearch(@QueryMap queryParameters: HashMap<String, String>) : Call<MainResult>
}