package com.viden.reader.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.viden.reader.utils.SecondaryItemAlpha
import com.viden.reader.utils.padding

@Composable
fun InfoScaffold(
    onAcceptClick: () -> Unit,
    acceptText: String,
    onRejectClick: () -> Unit,
    rejectText: String,
    icon: ImageVector,
    headlineText: String,
    titleText: String,
    content: @Composable() (ColumnScope.() -> Unit),
) {
    Scaffold(bottomBar = {
        Column(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.padding.medium, vertical = MaterialTheme.padding.small
            )
        ) {
            Button(
                onClick = onAcceptClick, modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = acceptText.ifEmpty { "Accept" })
            }

            OutlinedButton(
                onClick = onRejectClick, modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = rejectText.ifEmpty { "Reject" })
            }
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = MaterialTheme.padding.medium)
                .padding(top = 48.dp),
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )

            Text(text = headlineText, style = MaterialTheme.typography.headlineLarge)
            Text(
                text = titleText,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .alpha(SecondaryItemAlpha)
                    .padding(vertical = MaterialTheme.padding.small)
            )
            content()
        }
    }
}

@Preview
@Composable
fun InfoScaffoldPreview() {
    InfoScaffold(
        onAcceptClick = {},
        "",
        onRejectClick = {},
        "",
        icon = Icons.Outlined.Newspaper,
        "Headline",
        "subtitle",
        {
            Text(text = "content Text")
        },
    )
}