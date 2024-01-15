package com.hussein.ktorclientexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hussein.ktorclientexample.data.remote.dto.PostResponse
import com.hussein.ktorclientexample.data.remote.dto.PostService
import com.hussein.ktorclientexample.data.remote.dto.PostServiceImpl
import com.hussein.ktorclientexample.ui.theme.KtorClientExampleTheme

class MainActivity : ComponentActivity() {

    private val client = PostService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = client.getPosts()
                }
            )
            KtorClientExampleTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    LazyColumn{
                        items(posts.value){post->
                            Column(modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)) {
                                Text(text = post.title, fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = post.body, fontSize = 12.sp)

                            }
                        }
                    }
                }
            }
        }
    }
}