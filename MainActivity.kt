package com.example.spotifyclone

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mediaPlayer = MediaPlayer.create(this, R.raw.vip)

        setContent {

            var isPlaying by remember { mutableStateOf(false) }

            val songs = listOf(
                "VIP Song",
                "Night Vibe",
                "Chill Beat",
                "LoFi Mix"
            )

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {

                Column {

                    Text(
                        text = "Spotify Clone",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )

                    LazyColumn {

                        items(songs) { song ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {

                                        if (isPlaying) {
                                            mediaPlayer.pause()
                                        } else {
                                            mediaPlayer.start()
                                        }

                                        isPlaying = !isPlaying
                                    }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(android.R.drawable.ic_media_play),
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Column {

                                    Text(
                                        text = song,
                                        color = Color.White
                                    )

                                    Text(
                                        text = "Artist",
                                        color = Color.Gray
                                    )

                                }

                            }

                        }

                    }

                }

            }

        }
    }
}