package com.example.practiceschool.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceschool.MyNotification
import com.example.practiceschool.SchoolList
import com.example.practiceschool.data.SchoolDetails

@Composable
fun SchoolItem(school: SchoolDetails) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Surface() {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = school.school_name)
                Text(text = "Math score Average: ${school.sat_math_avg_score}")
                Text(text = "Writing score Average: ${school.sat_writing_avg_score}")
                Text(text = " Reading score Average: ${school.sat_critical_reading_avg_score}")
                Button(onClick = {
                        val notice = MyNotification(context = context, "FCM", "This is notification for ${school.school_name}")
                    notice.FireNotification()
                }) {
                    Text(text = "fire notification")

                }

            }

        }

    }
}


@Composable
fun HomeScreen(viewModel: SchoolViewModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally),
            elevation = 6.dp
        ) {
            Text(text = "Schools of the US")
        }
        SchoolList(schoolList = viewModel.schoolResponse)
    }
}

@Preview(showBackground = true)
@Composable
fun newPreview(){

}