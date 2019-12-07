package com.xebiaassignment.model


import com.google.gson.annotations.SerializedName

data class MostViewedArticlesResponse(
    @SerializedName("copyright")
    var copyright: String = "",
    @SerializedName("num_results")
    var numResults: Int = 0,
    @SerializedName("results")
    var results: List<Result> = listOf(),
    @SerializedName("status")
    var status: String = ""
) {
    data class Result(
        @SerializedName("abstract")
        var `abstract`: String = "",
        @SerializedName("adx_keywords")
        var adxKeywords: String = "",
        @SerializedName("asset_id")
        var assetId: Long = 0,
        @SerializedName("byline")
        var byline: String = "",
        @SerializedName("column")
        var column: String? = null,
        @SerializedName("id")
        var id: Long = 0,
        @SerializedName("media")
        var media: List<Media> = listOf(),
        @SerializedName("published_date")
        var publishedDate: String = "",
        @SerializedName("section")
        var section: String = "",
        @SerializedName("source")
        var source: String = "",
        @SerializedName("title")
        var title: String = "",
        @SerializedName("type")
        var type: String = "",
        @SerializedName("uri")
        var uri: String = "",
        @SerializedName("url")
        var url: String = "",
        @SerializedName("views")
        var views: Int = 0
    ) {
        data class Media(
            @SerializedName("approved_for_syndication")
            var approvedForSyndication: Int = 0,
            @SerializedName("caption")
            var caption: String = "",
            @SerializedName("copyright")
            var copyright: String = "",
            @SerializedName("media-metadata")
            var mediaMetadata: List<MediaMetadata> = listOf(),
            @SerializedName("subtype")
            var subtype: String = "",
            @SerializedName("type")
            var type: String = ""
        ) {
            data class MediaMetadata(
                @SerializedName("format")
                var format: String = "",
                @SerializedName("height")
                var height: Int = 0,
                @SerializedName("url")
                var url: String = "",
                @SerializedName("width")
                var width: Int = 0
            )
        }
    }
}