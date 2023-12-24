package com.digi.mywishlist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.digi.mywishlist.ui.UiEvent
import com.digi.mywishlist.ui.UiState
import com.digi.mywishlist.ui.theme.MyWishlistTheme

@ExperimentalMaterial3Api
@Composable
fun AddScreen(
    uiState: UiState,
    modifier: Modifier = Modifier,
    onEvent: (UiEvent) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add Item to Wishlist",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = .5f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()

                ) {

                    TextField(
                        label = { Text(text = "Title") },
                        modifier = Modifier.fillMaxWidth(),
                        value = uiState.title,
                        onValueChange = { onEvent(UiEvent.OnSetTitle(it)) },
                    )
                    Spacer(modifier = Modifier.padding(8.dp))

                    TextField(
                        label = { Text(text = "Website Url") },
                        modifier = Modifier.fillMaxWidth(),
                        value = uiState.website,
                        onValueChange = { onEvent(UiEvent.OnSetWebsite(it)) },
                    )
                    Spacer(modifier = Modifier.padding(8.dp))

                    TextField(
                        label = { Text(text = "Image Url") },
                        modifier = Modifier.fillMaxWidth(),
                        value = uiState.img,
                        onValueChange = { onEvent(UiEvent.OnSetImage(it)) },
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(text = "Priority")
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Absolute.Left
                    ) {
                        Card(
                            onClick = { },
                        ) {
                            Text(text = "Low", modifier = Modifier.padding(8.dp))
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Card(
                            onClick = { },

                            ) {
                            Text(text = "Medium", modifier = Modifier.padding(8.dp))
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Card(
                            onClick = { },

                            ) {
                            Text(text = "High", modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
            ExtendedFloatingActionButton(
                onClick = { onEvent(UiEvent.OnSaveClicked) },
                modifier = Modifier.width(150.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Add")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    MyWishlistTheme {
        AddScreen(uiState = UiState()) {}
    }
}