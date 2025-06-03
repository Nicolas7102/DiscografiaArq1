package com.example.musicdiscography

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.discografiaarq1.ui.screens.Screens
import com.example.discografiaarq1.ui.screens.albumlist.AlbumListScreenViewmodel
import com.example.discografiaarq1.ui.theme.DiscografiaArq1Theme

@Composable
fun AlbumListScreen(modifier: Modifier = Modifier,
                    vm: AlbumListScreenViewmodel = viewModel(),
                    navController: NavHostController
)
{
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Listado de Albumes",
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = vm.uiState.searchQuery,
                modifier = Modifier.weight(1f),
                label = { Text("Buscar album") },
                singleLine = true,
                onValueChange = { vm.updateSearchQuery(it) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {vm.fetchAlbums()}
            ) {
                Text("Buscar")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        AlbumUIList(vm.uiState.albumList,
            Modifier.fillMaxSize(),
            onClick = {
                id -> navController.navigate(Screens.AlbumDetail.route + "/${id}")
                println("Album seleccionado: ${Screens.AlbumDetail.route}/$id")
        })
    }

}