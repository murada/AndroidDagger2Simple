package com.mindorks.bootcamp.learndagger.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Post (

        @Expose
        @SerializedName("id")
        val id:String,

        @Expose
        @SerializedName("imgUrl")
        val imgUrl:String,

        @Expose
        @SerializedName("imgHeight")
        val imgHeight:Long ,

        @Expose
        @SerializedName("imgHWidth")
        val imgWidth:Long ,

        @Expose
        @SerializedName("user")
        val user:User,

        @Expose
        @SerializedName("likedBy")
        val likedBy:List<User>,

        @Expose
        @SerializedName("createdAt")
        val createdAt:Date

        ){

    data class User(

            @Expose
            @SerializedName("id")
            val id:String,

            @Expose
            @SerializedName("name")
            val name:String,

            @Expose
            @SerializedName("profilePicUrl")
            val profilePicUrl:String

    )

}
