package com.mindorks.bootcamp.learndagger.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.mindorks.bootcamp.learndagger.data.model.Dummy

data class DummyResponse (

        @Expose
        @SerializedName("statusCode")
        var statusCode:String,

        @Expose
        @SerializedName("message")
        var message:String,

        @Expose
        @SerializedName("data")
        var data:List<Dummy>

)