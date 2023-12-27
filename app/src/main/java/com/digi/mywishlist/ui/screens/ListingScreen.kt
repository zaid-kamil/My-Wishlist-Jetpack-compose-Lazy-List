@file:OptIn(ExperimentalGlideComposeApi::class)

package com.digi.mywishlist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.digi.mywishlist.data.Item
import com.digi.mywishlist.data.Priority
import com.digi.mywishlist.ui.UiState

@Composable
fun ListingScreen(
    uiState: UiState,
    onItemSelected: (Item) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "My Wishlist",
                style = MaterialTheme.typography.headlineLarge
            )
        }
        items(uiState.items) { item ->
            ItemCard(
                item = item,
                onClick = { onItemSelected(item) },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(item: Item, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = when (item.priority) {
                Priority.High -> Color.Red.copy(alpha = 0.2f)
                Priority.Medium -> Color.Green.copy(alpha = 0.2f)
                Priority.Low -> Color.Blue.copy(alpha = 0.2f)
            }
        )
    ) {
        if(item.isImgLocal){
            GlideImage(
                model = item.imgLocal,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(250.dp)
            )
        }else{
            GlideImage(
                model = item.img,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(250.dp)
            )
        }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.title)
            Text(text = item.website, style = MaterialTheme.typography.bodySmall)
        }
    }
}
