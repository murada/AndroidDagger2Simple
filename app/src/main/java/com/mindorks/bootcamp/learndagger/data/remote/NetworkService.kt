package com.mindorks.bootcamp.learndagger.data.remote

import android.content.Context
import com.mindorks.bootcamp.demo.di.ApplicationContext
import com.mindorks.bootcamp.demo.di.NetworkInfo
import com.mindorks.bootcamp.learndagger.data.Networking
import com.mindorks.bootcamp.learndagger.data.model.Post
import com.mindorks.bootcamp.learndagger.data.remote.request.DummyRequest
import com.mindorks.bootcamp.learndagger.data.remote.response.DummyResponse
import com.mindorks.bootcamp.learndagger.data.remote.response.GeneralResponse
import com.mindorks.bootcamp.learndagger.data.remote.response.PostListResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Inject
import javax.inject.Singleton

/*

@Singleton
class NetworkService
@Inject constructor(@ApplicationContext private val context: Context, @NetworkInfo private val apiKey: String) {

    val dummyData: String
        get() = "NETWORK_DUMMY_DATA"

}*/

interface NetworkService{

    @POST(EndPoints.DUMMY)
    fun doDummyCall(
        @Body dummyRequest: DummyRequest,
        @Header(Networking.HEADER_API_KEY) apiKey:String = Networking.API_KEY
    ):Single<DummyResponse>


    @GET(EndPoints.DUMMY)
    fun doDummyCall(
            @Header(Networking.HEADER_API_KEY) apiKey:String = Networking.API_KEY
    ):Single<DummyResponse>


    @GET(EndPoints.HOME_POST_LIST)
    fun doHomePostListCall(
            @Query("firstPostId") firstPostId:String?,
            @Query("lastPostId") lastPostId:String?,
            @Header(Networking.HEADER_USER_ID) userId:String,
            @Header(Networking.HEADER_ACCESS_TOKEN) accessToken:String,
            @Header(Networking.HEADER_API_KEY) apiKey:String = Networking.API_KEY

    ):Single<PostListResponse>


    @DELETE(EndPoints.POST_DELETE)
    fun doPostDeleteCall(
            @Path("postId") postId:String,
            @Header(Networking.HEADER_USER_ID) userId:String,
            @Header(Networking.HEADER_ACCESS_TOKEN) accessToken:String,
            @Header(Networking.HEADER_API_KEY) apiKey:String = Networking.API_KEY

    ):Single<GeneralResponse>
}