package com.example.discografiaarq1.data

import android.util.Log
import Album
import AlbumResponse
import com.google.gson.Gson
import kotlinx.coroutines.delay

class AlbumTestDataSource : IAlbumDataSource {

    override suspend fun getAlbums(search: String) : List<Album> {

        val gson = Gson()
        val albumResponse = gson.fromJson(json, AlbumResponse::class.java)
        Log.d("GSONALBUMS", albumResponse.albums.toString())
        Log.d("GSONALBUMSTITLE", albumResponse.albums[0].title)
        return albumResponse.albums
    }

    override suspend fun getAlbumById(albumId: String): Album {
        return getAlbums("") [0]
    }

    var json = """
      {
      "created": "2025-05-29T20:51:49.294Z",
      "count": 4,
      "offset": 0,
      "release-groups": [
        {
          "id": "52e0e904-7148-3534-ac89-b0620499b6df",
          "type-id": "f529b476-6e62-324f-b0aa-1f3e33d313fc",
          "score": 100,
          "primary-type-id": "f529b476-6e62-324f-b0aa-1f3e33d313fc",
          "artist-credit-id": "ed04469d-f345-3e00-a063-1257ab49c088",
          "count": 1,
          "title": "Human After All",
          "first-release-date": "2001-01-02",
          "primary-type": "Album",
          "artist-credit": [
            {
              "name": "Lis Harvey",
              "artist": {
                "id": "a82e7861-83d0-4525-ad0d-fff1f7569c8e",
                "name": "Lis Harvey",
                "sort-name": "Harvey, Lis"
              }
            }
          ],
          "releases": [
            {
              "id": "ff8d859c-39f3-4c00-998d-66af5bec266f",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            }
          ]
        },
        {
          "id": "f9e8042a-674e-3f01-80ec-7f0ab1c537df",
          "type-id": "f529b476-6e62-324f-b0aa-1f3e33d313fc",
          "score": 100,
          "primary-type-id": "f529b476-6e62-324f-b0aa-1f3e33d313fc",
          "artist-credit-id": "2ad79928-9236-33a3-830c-cc909d38f0c7",
          "count": 19,
          "title": "Human After All",
          "first-release-date": "2005-03-01",
          "primary-type": "Album",
          "artist-credit": [
            {
              "name": "Daft Punk",
              "artist": {
                "id": "056e4f3e-d505-4dad-8ec1-d04f521cbb56",
                "name": "Daft Punk",
                "sort-name": "Daft Punk",
                "disambiguation": "French electronic duo",
                "aliases": [
                  {
                    "sort-name": "Duft Punk",
                    "type-id": "1937e404-b981-3cb7-8151-4c86ebfc8d8e",
                    "name": "Duft Punk",
                    "locale": null,
                    "type": "Search hint",
                    "primary": null,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "ダフト パンク",
                    "type-id": "894afba6-2816-3c24-8072-eadb66bd04bc",
                    "name": "ダフト・パンク",
                    "locale": "ja",
                    "type": "Artist name",
                    "primary": true,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "Daft Punk",
                    "type-id": "894afba6-2816-3c24-8072-eadb66bd04bc",
                    "name": "Daft Punk",
                    "locale": "en",
                    "type": "Artist name",
                    "primary": true,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "Da Funk",
                    "type-id": "1937e404-b981-3cb7-8151-4c86ebfc8d8e",
                    "name": "Da Funk",
                    "locale": null,
                    "type": "Search hint",
                    "primary": null,
                    "begin-date": null,
                    "end-date": null
                  }
                ]
              }
            }
          ],
          "releases": [
            {
              "id": "b3923734-6636-4e81-8330-0990a318e10e",
              "status-id": "518ffc83-5cde-34df-8627-81bff5093d92",
              "title": "Human After All",
              "status": "Promotion"
            },
            {
              "id": "8f4d3899-be98-4352-a9f0-8853cd6fb21e",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "e4aad7bc-f587-4a64-94b3-d16979007313",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "e890f782-bc39-43dd-890d-0c906c2641b2",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "9e3978e5-221d-4c9f-ba12-c1d05da1e64d",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "e2b832c5-65cb-496d-801b-9d24c9b85a90",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "382e22d2-27ad-49c6-ab3b-aaa6e860447d",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "ecf98192-83c3-4176-afec-8a069eb4de8f",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "abbc40a0-2bcc-449e-bdd0-2dbae3213517",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "e7b4cfcd-6ad2-4426-a8be-103f24cd62c6",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "7f293aa6-8c19-4695-80bb-63ac40a0f2b5",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "2b2d70aa-8327-43d0-9683-a1216c295611",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "5005475a-cbd4-4e07-8d62-45bac1285673",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "fd07d0fc-a68a-3b77-95c9-fd7ec7fea013",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "877970e7-3bae-37ef-bd9f-b28c2c948dbb",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "77a2f001-ae10-45fe-8d56-6069edfe20fe",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "0443ddba-cc5d-347c-9859-d72a70eab674",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "86d4299f-810e-3c4c-a324-2cc03672ed00",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            },
            {
              "id": "9c02dc5c-6725-314b-a5d1-b6097ff0c6ce",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All",
              "status": "Official"
            }
          ],
          "tags": [
            {
              "count": 2,
              "name": "trip-hop"
            },
            {
              "count": 1,
              "name": "rock"
            },
            {
              "count": 11,
              "name": "electronic"
            },
            {
              "count": 11,
              "name": "house"
            },
            {
              "count": 1,
              "name": "experimental"
            },
            {
              "count": 4,
              "name": "electro"
            },
            {
              "count": 3,
              "name": "bass"
            },
            {
              "count": 5,
              "name": "abstract"
            },
            {
              "count": 4,
              "name": "french house"
            },
            {
              "count": 1,
              "name": "dance and electronica"
            },
            {
              "count": 2,
              "name": "left-field house"
            },
            {
              "count": 4,
              "name": "club/dance"
            }
          ]
        },
        {
          "id": "16ea0f65-3462-3283-a3eb-e81dcc92c1d5",
          "type-id": "0c60f497-ff81-3818-befd-abfc84a4858b",
          "score": 74,
          "primary-type-id": "f529b476-6e62-324f-b0aa-1f3e33d313fc",
          "artist-credit-id": "2ad79928-9236-33a3-830c-cc909d38f0c7",
          "count": 4,
          "title": "Human After All: Remixes",
          "first-release-date": "2006-03-29",
          "primary-type": "Album",
          "secondary-types": [
            "Remix"
          ],
          "secondary-type-ids": [
            "0c60f497-ff81-3818-befd-abfc84a4858b"
          ],
          "artist-credit": [
            {
              "name": "Daft Punk",
              "artist": {
                "id": "056e4f3e-d505-4dad-8ec1-d04f521cbb56",
                "name": "Daft Punk",
                "sort-name": "Daft Punk",
                "disambiguation": "French electronic duo",
                "aliases": [
                  {
                    "sort-name": "Duft Punk",
                    "type-id": "1937e404-b981-3cb7-8151-4c86ebfc8d8e",
                    "name": "Duft Punk",
                    "locale": null,
                    "type": "Search hint",
                    "primary": null,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "ダフト パンク",
                    "type-id": "894afba6-2816-3c24-8072-eadb66bd04bc",
                    "name": "ダフト・パンク",
                    "locale": "ja",
                    "type": "Artist name",
                    "primary": true,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "Daft Punk",
                    "type-id": "894afba6-2816-3c24-8072-eadb66bd04bc",
                    "name": "Daft Punk",
                    "locale": "en",
                    "type": "Artist name",
                    "primary": true,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "Da Funk",
                    "type-id": "1937e404-b981-3cb7-8151-4c86ebfc8d8e",
                    "name": "Da Funk",
                    "locale": null,
                    "type": "Search hint",
                    "primary": null,
                    "begin-date": null,
                    "end-date": null
                  }
                ]
              }
            }
          ],
          "releases": [
            {
              "id": "cae7dcc6-f241-4287-93f6-8dd89fabe7df",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All: Remixes",
              "status": "Official"
            },
            {
              "id": "3102bf55-5132-4b52-bf8b-f976d08fea0b",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All ~原点回帰 -Remixes-",
              "status": "Official"
            },
            {
              "id": "98a4b36b-8943-4d99-90c0-028635b8fe6e",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All: Remixes",
              "status": "Official"
            },
            {
              "id": "f2dc6f34-87d8-485c-9df4-1ad5d4648a98",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All: Remixes",
              "status": "Official"
            }
          ],
          "tags": [
            {
              "count": 5,
              "name": "electronic"
            },
            {
              "count": 5,
              "name": "big beat"
            },
            {
              "count": 3,
              "name": "house"
            },
            {
              "count": 3,
              "name": "experimental"
            },
            {
              "count": 3,
              "name": "electro"
            },
            {
              "count": 3,
              "name": "techno"
            },
            {
              "count": 1,
              "name": "disco"
            },
            {
              "count": 1,
              "name": "film score"
            }
          ]
        },
        {
          "id": "3c22791b-bbfe-466f-a818-611767716335",
          "type-id": "dd2a21e1-0c00-3729-a7a0-de60b84eb5d1",
          "score": 74,
          "primary-type-id": "f529b476-6e62-324f-b0aa-1f3e33d313fc",
          "artist-credit-id": "2ad79928-9236-33a3-830c-cc909d38f0c7",
          "count": 1,
          "title": "Human After All / Daft Club",
          "first-release-date": "2022",
          "primary-type": "Album",
          "secondary-types": [
            "Compilation"
          ],
          "secondary-type-ids": [
            "dd2a21e1-0c00-3729-a7a0-de60b84eb5d1"
          ],
          "artist-credit": [
            {
              "name": "Daft Punk",
              "artist": {
                "id": "056e4f3e-d505-4dad-8ec1-d04f521cbb56",
                "name": "Daft Punk",
                "sort-name": "Daft Punk",
                "disambiguation": "French electronic duo",
                "aliases": [
                  {
                    "sort-name": "Duft Punk",
                    "type-id": "1937e404-b981-3cb7-8151-4c86ebfc8d8e",
                    "name": "Duft Punk",
                    "locale": null,
                    "type": "Search hint",
                    "primary": null,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "ダフト パンク",
                    "type-id": "894afba6-2816-3c24-8072-eadb66bd04bc",
                    "name": "ダフト・パンク",
                    "locale": "ja",
                    "type": "Artist name",
                    "primary": true,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "Daft Punk",
                    "type-id": "894afba6-2816-3c24-8072-eadb66bd04bc",
                    "name": "Daft Punk",
                    "locale": "en",
                    "type": "Artist name",
                    "primary": true,
                    "begin-date": null,
                    "end-date": null
                  },
                  {
                    "sort-name": "Da Funk",
                    "type-id": "1937e404-b981-3cb7-8151-4c86ebfc8d8e",
                    "name": "Da Funk",
                    "locale": null,
                    "type": "Search hint",
                    "primary": null,
                    "begin-date": null,
                    "end-date": null
                  }
                ]
              }
            }
          ],
          "releases": [
            {
              "id": "9a4a5e70-8611-473e-a014-006068b59feb",
              "status-id": "4e304316-386d-3409-af2e-78857eec5cfe",
              "title": "Human After All / Daft Club",
              "status": "Official"
            }
          ]
        }
      ]
    }
    """.trimIndent()
}