package com.example.anfibiosapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter

@Composable
fun AmphibianList(amphibians: List<Amphibian>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(amphibians) { amphibian ->
            AmphibianItem(amphibian = amphibian, onClick = {
                navController.navigate("amphibian_detail/${amphibian.name}")
            })
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun AmphibianItem(amphibian: Amphibian, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(amphibian.imageResId),
                contentDescription = amphibian.name,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = amphibian.name, style = MaterialTheme.typography.titleMedium)
                Text(text = amphibian.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun AmphibianDetail(amphibian: Amphibian) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = amphibian.name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = rememberImagePainter(amphibian.imageResId),
            contentDescription = amphibian.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = amphibian.description)
    }
}