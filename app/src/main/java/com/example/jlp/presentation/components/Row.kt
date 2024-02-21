package com.example.jlp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomRow(startText: String,
              endContent: @Composable (() -> Unit)? = null,
              fontSize: TextUnit = 12.sp) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Adjust padding as needed
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = startText,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start,
                style = TextStyle(
                    fontSize = fontSize,
                )
            )

            endContent?.invoke() ?: Spacer(modifier = Modifier.weight(1f))
        }

        Divider(modifier = Modifier.padding(horizontal = 16.dp))
    }
}