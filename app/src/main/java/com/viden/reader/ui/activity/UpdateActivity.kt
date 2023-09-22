package com.viden.reader.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.NewReleases
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichTextStyle
import com.halilibo.richtext.ui.material3.Material3RichText
import com.halilibo.richtext.ui.string.RichTextStringStyle
import com.viden.reader.net.GithubRelease
import com.viden.reader.ui.component.InfoScaffold
import com.viden.reader.ui.fragment.SettingsFragment
import com.viden.reader.utils.padding

class UpdateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val githubRelease: GithubRelease =
            intent.getSerializableExtra(SettingsFragment.GITHUB_RELEASE) as GithubRelease
        setContent {
            MaterialTheme {
                UpdateInfo(githubRelease)
            }
        }
    }


    @Composable
    fun UpdateInfo(githubRelease: GithubRelease) {
        InfoScaffold(
            onAcceptClick = { updateNow(githubRelease.htmlUrl) },
            acceptText = "下载",
            onRejectClick = {
                finish()
            },
            rejectText = "以后再说",
            icon = Icons.Outlined.NewReleases,
            "有新版本！",
            githubRelease.tagName,
            {
                Material3RichText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.padding.large),
                    style = RichTextStyle(
                        stringStyle = RichTextStringStyle(
                            linkStyle = SpanStyle(color = MaterialTheme.colorScheme.primary),
                        ),
                    ),
                ) {
                    Markdown(content = githubRelease.body)
                }
            },
        )
    }

    private fun updateNow(releaseLink: String) {
        val intent = Intent(Intent.ACTION_VIEW, releaseLink.toUri())
        startActivity(intent)
    }

    @Preview
    @Composable
    fun UpdateInfoPreview() {
        val githubRelease = GithubRelease()
        githubRelease.tagName = "v0.0.1"
        MaterialTheme {
            UpdateInfo(githubRelease)
        }
    }
}