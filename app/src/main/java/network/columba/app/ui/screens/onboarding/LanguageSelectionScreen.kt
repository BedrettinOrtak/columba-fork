package network.columba.app.ui.screens.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import network.columba.app.R

private data class StartupLanguageOption(
    val tag: String,
    val flagEmoji: String? = null,
    val useKurdishTricolor: Boolean = false,
    val labelResId: Int,
)

private val STARTUP_LANGUAGE_OPTIONS = listOf(
    StartupLanguageOption(tag = "tr", flagEmoji = "🇹🇷", labelResId = R.string.language_turkish),
    StartupLanguageOption(tag = "fa", flagEmoji = "🇮🇷", labelResId = R.string.language_persian),
    StartupLanguageOption(tag = "en", flagEmoji = "🇬🇧", labelResId = R.string.language_english),
    StartupLanguageOption(tag = "ku", useKurdishTricolor = true, labelResId = R.string.language_kurdish),
)

@Composable
fun LanguageSelectionScreen(
    onLanguageSelected: (String) -> Unit,
    onBack: (() -> Unit)? = null,
) {
    var selectedTag by remember { mutableStateOf<String?>(null) }

    // Capture system back when a back action is available so the user can
    // exit the screen without being forced to choose a language.
    if (onBack != null) {
        BackHandler(enabled = true, onBack = onBack)
    }

    // Layout: top bar (back arrow when available) + scrollable content +
    // sticky footer with the Continue button. Continue stays at the bottom
    // where it is expected, and is always visible regardless of screen size.
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Top bar with back arrow — only when there is somewhere to return to.
        if (onBack != null) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.onboarding_action_back),
                    )
                }
            }
        }

        // Scrollable content area
        Column(
            modifier =
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
                    .padding(top = if (onBack != null) 0.dp else 24.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(R.string.first_launch_language_title),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.first_launch_language_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Spacer(modifier = Modifier.height(20.dp))

            STARTUP_LANGUAGE_OPTIONS.forEach { option ->
                val isSelected = selectedTag == option.tag
                Card(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .then(
                                if (isSelected) {
                                    Modifier.border(
                                        width = 2.dp,
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = RoundedCornerShape(14.dp),
                                    )
                                } else {
                                    Modifier
                                },
                            )
                            .clickable { selectedTag = option.tag },
                    shape = RoundedCornerShape(14.dp),
                    colors =
                        CardDefaults.cardColors(
                            containerColor =
                                if (isSelected) {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surfaceVariant
                                },
                        ),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            StartupLanguageFlag(option = option)
                            Text(
                                text = stringResource(option.labelResId),
                                style = MaterialTheme.typography.titleMedium,
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint =
                                if (isSelected) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
                                },
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.first_launch_language_hint),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        // Sticky footer: Continue button always visible at the bottom.
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f))
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
        ) {
            Button(
                onClick = { selectedTag?.let { onLanguageSelected(it) } },
                enabled = selectedTag != null,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    text = stringResource(R.string.onboarding_action_continue),
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Composable
private fun StartupLanguageFlag(option: StartupLanguageOption) {
    if (option.useKurdishTricolor) {
        val shape = RoundedCornerShape(4.dp)
        Row(
            modifier =
                Modifier
                    .width(28.dp)
                    .height(20.dp)
                    .clip(shape)
                    .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.35f), shape),
        ) {
            Box(modifier = Modifier.weight(1f).fillMaxSize().background(Color(0xFFFFD600)))
            Box(modifier = Modifier.weight(1f).fillMaxSize().background(Color(0xFFD50000)))
            Box(modifier = Modifier.weight(1f).fillMaxSize().background(Color(0xFF2E7D32)))
        }
    } else {
        Text(
            text = option.flagEmoji.orEmpty(),
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

