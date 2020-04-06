package com.mindorks.bootcamp.learndagger.data.remote.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DummyRequest (
        @Expose
        @SerializedName("id")
        val id:String
)