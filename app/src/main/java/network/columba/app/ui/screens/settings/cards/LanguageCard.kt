package network.columba.app.ui.screens.settings.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import network.columba.app.R
import network.columba.app.ui.components.CollapsibleSettingsCard

data class LanguageOption(
    val tag: String,      // BCP-47 language tag, e.g. "tr", "fa", "ku", "en", "" = system default
    val labelResId: Int,
)

private val LANGUAGE_OPTIONS = listOf(
    LanguageOption("", R.string.language_system_default),
    LanguageOption("en", R.string.language_english),
    LanguageOption("tr", R.string.language_turkish),
    LanguageOption("fa", R.string.language_persian),
    LanguageOption("ku", R.string.language_kurdish),
)

@Composable
fun LanguageCard(
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    selectedLanguage: String,
    onLanguageChange: (String) -> Unit,
) {
    CollapsibleSettingsCard(
        title = stringResource(R.string.language_title),
        icon = Icons.Default.Language,
        isExpanded = isExpanded,
        onExpandedChange = onExpandedChange,
    ) {
        Text(
            text = stringResource(R.string.language_description),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Column(
            modifier = Modifier.selectableGroup(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            LANGUAGE_OPTIONS.forEach { option ->
                val isSelected = selectedLanguage == option.tag
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = isSelected,
                                onClick = { onLanguageChange(option.tag) },
                                role = Role.RadioButton,
                            ).padding(vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    RadioButton(selected = isSelected, onClick = null)
                    Text(
                        text = stringResource(option.labelResId),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}

