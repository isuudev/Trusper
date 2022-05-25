package com.isuu.trusper.model

import com.isuu.trusper.model.entity.BaseEntity
import com.isuu.trusper.model.entity.FlowEntity
import retrofit2.http.*

interface Api {

    /**
     * GET
     * https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?
     * q=taylor%20swift&pageNumber=1&pageSize=10&autoCorrect=true
     */
    @GET("/api/Search/ImageSearchAPI?q=taylor%20swift&autoCorrect=true")
    suspend fun apiFlowList(
        @Query("pageNumber") pageIndex: Int,
        @Query("pageSize") pageSize: Int): BaseEntity<List<FlowEntity>>

    /**
    {
    "_type": "images",
    "totalCount": 1078,
    "value": [
    {
    "url": "http://cache.umusic.com/_sites/_halo/taylorswift/images/meta-image.jpg",
    "height": 630,
    "width": 1200,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=1094927124898698511",
    "thumbnailHeight": 157,
    "thumbnailWidth": 299,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift - Official Website",
    "provider": {
    "name": "umusic",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://www.taylorswift.com/"
    },
    {
    "url": "https://cdn.cnn.com/cnnnext/dam/assets/201215085238-taylor-swift-2020-sundance-super-tease.jpg",
    "height": 619,
    "width": 1100,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=8421264495872280999",
    "thumbnailHeight": 154,
    "thumbnailWidth": 273,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift's re-recorded 'Love Story' is back on top of the charts - CNN",
    "provider": {
    "name": "cnn",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "http://cnn.com/2021/02/22/entertainment/taylor-swift"
    },
    {
    "url": "https://pmcvariety.files.wordpress.com/2018/10/taylor_swift.png?w=979",
    "height": 880,
    "width": 979,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=8673048286540026347",
    "thumbnailHeight": 246,
    "thumbnailWidth": 274,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift - Variety500 - Top 500 Entertainment Business Leaders | Variety.com",
    "provider": {
    "name": "wordpress",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://variety.com/exec/taylor-swift/"
    },
    {
    "url": "https://images.tmz.com/2014/12/13/taylor-swift-300x250.jpg",
    "height": 250,
    "width": 300,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=1491532148936957876",
    "thumbnailHeight": 187,
    "thumbnailWidth": 224,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift  News, Pictures, and Videos | TMZ.com",
    "provider": {
    "name": "tmz",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://www.tmz.com/person/taylor-swift/"
    },
    {
    "url": "https://media.npr.org/assets/music/sotd/2009/11/taylor_swift_wide-507c0856fc2fed7724ecbae5540c2b499c649e37.jpg?s=1400",
    "height": 281,
    "width": 500,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=6633699864716525031",
    "thumbnailHeight": 140,
    "thumbnailWidth": 249,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift : NPR",
    "provider": {
    "name": "npr",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://www.npr.org/artists/120581188/taylor-swift"
    },
    {
    "url": "https://cdn.britannica.com/86/182086-050-5FB81069/singer-Taylor-swift-2013.jpg",
    "height": 1600,
    "width": 1235,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=7600856393698390688",
    "thumbnailHeight": 299,
    "thumbnailWidth": 231,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift | Biography, Albums, Songs, & Facts | Britannica",
    "provider": {
    "name": "britannica",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://www.britannica.com/biography/Taylor-Swift"
    },
    {
    "url": "https://cdn.pastemagazine.com/www/articles/2022/01/24/taylorswift-damonalbarn-main.jpg",
    "height": 381,
    "width": 678,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=3114464616201899542",
    "thumbnailHeight": 142,
    "thumbnailWidth": 252,
    "base64Encoding": null,
    "name": "Taylor Swift Calls out Damon Albarn for Claiming She \"Doesn't Write Her Own Songs\"",
    "title": "Taylor Swift Calls out Damon Albarn for Claiming She \"Doesn't Write Her Own Songs\" - Paste",
    "provider": {
    "name": "pastemagazine",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://www.pastemagazine.com/music/taylor-swift/damon-albarn-songwriting-controversy/"
    },
    {
    "url": "https://www.looktothestars.org/photo/6242-taylor-swift/story_half_width.jpg",
    "height": 280,
    "width": 280,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=3098231922919891677",
    "thumbnailHeight": 210,
    "thumbnailWidth": 210,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift: Charity Work & Causes - Look to the Stars",
    "provider": {
    "name": "looktothestars",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://www.looktothestars.org/celebrity/taylor-swift"
    },
    {
    "url": "https://www.pinkvilla.com/files/styles/fbimagesection/public/taylor_swift_birthday.jpeg?itok=VRq6drie",
    "height": 310,
    "width": 580,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=8039867206085482440",
    "thumbnailHeight": 202,
    "thumbnailWidth": 379,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift Birthday: 6 PHOTOS of the singer's hottest looks from her performances",
    "provider": {
    "name": "pinkvilla",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://www.pinkvilla.com/photos/taylor-swift/taylor-swift-birthday-6-photos-singers-hottest-looks-her-performances-966132"
    },
    {
    "url": "https://virtualpiano.net/wp-content/uploads/2020/08/Taylor-Swift-Artist-on-Virtual-Piano-Play-Piano-Online.jpg",
    "height": 1200,
    "width": 1200,
    "thumbnail": "https://rapidapi.usearch.com/api/thumbnail/get?value=4533077759247113267",
    "thumbnailHeight": 300,
    "thumbnailWidth": 300,
    "base64Encoding": null,
    "name": "",
    "title": "Taylor Swift Music Sheets | Artists | Play Songs on Virtual Piano",
    "provider": {
    "name": "virtualpiano",
    "favIcon": "",
    "favIconBase64Encoding": ""
    },
    "imageWebSearchUrl": "https://usearch.com/search/taylor%20swift/images",
    "webpageUrl": "https://virtualpiano.net/artists/taylor-swift/"
    }
    ]
    }
     */
}

