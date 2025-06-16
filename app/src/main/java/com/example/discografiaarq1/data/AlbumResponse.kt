import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("release-groups")
    val albums: List<Album>
)

data class Album(
    val id: String = "",
    val title: String = "",
    @SerializedName("artist-credit")
    val artistCredit: List<ArtistCredit>? = null,
    @SerializedName("first-release-date")
    val firstReleaseDate: String = "",
    val releases: List<Release>? = null,
    var imageUrl: String? = null
)


data class ArtistCredit(
    val name: String? = null
)

data class Release(
    val id: String? = null,
    val title: String? = null,
    val status: String? = null
)

data class AlbumDetailResponse(
    @SerializedName("artist-credit")
    val artistCredit: List<ArtistCredit>,
    val releases: List<Release>
)

data class Tracks(
    @SerializedName("data-tracks")
    val songs: List<Song>
)

data class Song(
    val title: String
)

fun emptyAlbum() : Album {
    return Album()
}
