import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("release-groups")
    val albums: List<Album>
)

data class Album(
    val id: String,
    val title: String,
    @SerializedName("artist-credit")
    val artistCredit: List<ArtistCredit>?,
    @SerializedName("first-release-date")
    val firstReleaseDate: String,
    val releases: List<Release>?,
    var imageUrl: String? = null
)

data class ArtistCredit(
    val name: String
)

data class Release(
    val id: String,
    val title: String,
    val status: String
)

data class AlbumDetailResponse(
    val media: List<Tracks>
)

data class Tracks(
    @SerializedName("data-tracks")
    val songs: List<Song>
)

data class Song(
    val title: String
)

fun emptyAlbum() : Album {
    return Album("", "", emptyList(), "", emptyList(), "")
}