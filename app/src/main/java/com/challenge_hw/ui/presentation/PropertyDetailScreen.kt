package com.challenge_hw.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.challenge_hw.data.models.City
import com.challenge_hw.data.models.FreeCancellation
import com.challenge_hw.data.models.Location
import com.challenge_hw.data.models.Price
import com.challenge_hw.data.models.Property

@Composable
fun PropertyDetailScreen(
    propertyId: String?
) {
    // Aqui você pode buscar os detalhes da propriedade com o `propertyId` ou simular os dados
    val property = getPropertyById(propertyId)  // Este método seria uma busca em uma base de dados ou API

    property.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = it.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description: ${it.overview}", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Price: From $${it.lowestPricePerNight.value}/night", style = MaterialTheme.typography.titleSmall)
        }
    }
}

fun getPropertyById(propertyId: String?): Property {
    // Simulação de uma busca de propriedade por ID
    return Property(
        id = 1,
        name = "Sample Property",
        overview = "This is a detailed description of the property.",
        lowestPricePerNight = Price(100.0.toString(), "USD"),
        starRating = 4.5,
        isFeatured = true,
        type = "Hotel",
        address1 = "1234 Elm Street",
        freeCancellationAvailable = true,
        freeCancellation = FreeCancellation("Free Cancellation", "You can cancel your reservation for free."),
        location = Location(City(1, "City", 1, "Country"), "Region")
    )
}
