package com.challenge_hw.ui.presentation

import android.text.Spanned
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.navigation.NavHostController
import com.challenge_hw.data.models.Property

@Composable
fun PropertyDetailScreen(
    navController: NavHostController,
    property: Property?
) {

    if (property == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading property details...", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = property.name,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Rating: ${property.starRating}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(8.dp))
                if (property.isFeatured) {
                    Text(
                        text = "★",
                        style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary)
                    )
                }
            }

            Text(
                text = "Price: From ${property.lowestPricePerNight.value} ${property.lowestPricePerNight.currency} / night",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Location:",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = buildingLocation(property),
                style = MaterialTheme.typography.bodyMedium
            )

            if (property.location?.region != null) {
                Text(
                    text = "Region: ${property.location.region}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Overview:",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = formatHTMLContent(property).toString(),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            if (property.freeCancellationAvailable) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .background(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Free Cancellation:",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = property.freeCancellation.label,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Back")
            }
        }
    }
}

private fun formatHTMLContent(property: Property): Spanned {
    return HtmlCompat.fromHtml(
        property.overview,
        HtmlCompat.FROM_HTML_MODE_LEGACY
    )
}

private fun buildingLocation(property: Property): String {
    if (property.location?.city == null) {
        return "Unknown"
    }
    return "${property.location.city.name}, ${property.location.city.country}, ${property.location.region}"
}
