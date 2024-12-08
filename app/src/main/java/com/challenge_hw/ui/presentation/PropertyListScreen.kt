package com.challenge_hw.ui.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.challenge_hw.R
import com.challenge_hw.data.models.Property
import com.challenge_hw.data.repository.PropertyRepository
import com.challenge_hw.data.service.PropertyApi
import com.challenge_hw.ui.theme.ChallengehwTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PropertyListScreen(viewModel: PropertyViewModel) {

    val properties = viewModel.propertiesState

    LaunchedEffect(Unit) {
        viewModel.fetchProperties()
    }

    Scaffold(
        topBar = {
            StyledTopAppBar()
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(properties.size) { index ->
                PropertyItem(property = properties[index])
            }
        }
    }
}

//this is the top app bar component
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyledTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Property List",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                color = colorResource(id = R.color.purple_700),
                textAlign = TextAlign.Center
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.orange_secondary),
        )
    )
}

//this is the property item component
@Composable
fun PropertyItem(property: Property) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = property.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(id = R.color.purple_500)
                )
                if (property.isFeatured) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Featured",
                        tint = colorResource(id = R.color.rating_star),
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(
                        text = "⭐ ${String.format("%.1f", property.starRating)}",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }

//            Log.d("API Response", "Star Rating: ${property.starRating}")

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "From $${property.lowestPricePerNight.value}/night",
                fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
                color = colorResource(id = R.color.orange_primary)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPropertyListScreen() {
    ChallengehwTheme {
        PropertyListScreen(
            viewModel = PropertyViewModel(PropertyRepository(PropertyApi()))
        )
    }
}
