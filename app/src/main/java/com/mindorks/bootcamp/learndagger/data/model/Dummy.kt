package com.mindorks.bootcamp.learndagger.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Dummy(

        @Expose
        @SerializedName("name")
        val name : String ,

        @Expose
        @SerializedName("imgUrl")
        val imgUrl:String
)
