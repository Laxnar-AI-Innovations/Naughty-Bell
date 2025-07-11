package com.naughtybell.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naughtybell.app.R

@Composable
fun HomeScreen() {
    val therapists = remember { sampleTherapists() }
    var query by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text("Naughty Bell")
            },
            actions = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painterResource(id = R.drawable.ic_coin), contentDescription = null)
                    Text("0", fontWeight = FontWeight.Bold)
                    Spacer(Modifier.width(16.dp))
                }
            }
        )
        // Search Bar
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Search name") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }
        )
        // TODO Filters chips row
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(therapists) { therapist ->
                TherapistCard(therapist)
            }
        }
        // Bottom Navigation Placeholder
        NavigationBar {
            NavigationBarItem(
                selected = true,
                onClick = {},
                icon = { Icon(Icons.Default.Menu, null) },
                label = { Text("Home") }
            )
            NavigationBarItem(selected = false, onClick = {}, icon = {
                Icon(Icons.Default.Menu, null)
            }, label = { Text("History") })
            NavigationBarItem(selected = false, onClick = {}, icon = {
                Icon(Icons.Default.Menu, null)
            }, label = { Text("Profile") })
        }
    }
}

@Composable
fun TherapistCard(therapist: Therapist) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            // Avatar
            Image(
                painter = painterResource(id = R.drawable.ic_avatar_placeholder),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(therapist.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(therapist.tagline, color = Color.Gray, fontSize = 14.sp)
                Text(therapist.languages.joinToString(), color = Color.DarkGray, fontSize = 12.sp)
                Spacer(Modifier.height(4.dp))
                Row {
                    Button(onClick = { /* TODO audio call */ }) { Text("Play") }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = { /* TODO video call */ }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE91E63))) {
                        Icon(painterResource(id = R.drawable.ic_coin), contentDescription = null)
                        Spacer(Modifier.width(4.dp))
                        Text("${therapist.rate}/min")
                    }
                }
            }
        }
    }
}

data class Therapist(
    val name: String,
    val tagline: String,
    val languages: List<String>,
    val rate: Int
)

fun sampleTherapists() = listOf(
    Therapist("Maitreyi", "Peace Partner", listOf("Hindi"), 11),
    Therapist("Shanvi Agarwal", "Professional Listener", listOf("Hindi"), 11),
    Therapist("Smitu", "Joy Helper", listOf("Hindi", "Odia"), 11)
) 