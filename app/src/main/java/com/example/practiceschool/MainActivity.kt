package com.example.practiceschool

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.IconCompat
import com.example.practiceschool.data.SchoolDetails
import com.example.practiceschool.ui.theme.PracticeSchoolTheme
import com.example.practiceschool.view.HomeScreen
import com.example.practiceschool.view.SchoolItem
import com.example.practiceschool.view.SchoolViewModel

class MainActivity : ComponentActivity() {


    private val schoolViewModel by viewModels<SchoolViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PracticeSchoolTheme {

                Surface(
                    color = MaterialTheme.colors.background
                ) {

                }
                HomeScreen(viewModel = schoolViewModel)
                schoolViewModel.getSchools()
            }
        }
    }
}


@Composable
fun SchoolList(schoolList: List<SchoolDetails>) {
    LazyColumn {
        itemsIndexed(items = schoolList) { index, item ->
            SchoolItem(school = item)
        }
    }
}

