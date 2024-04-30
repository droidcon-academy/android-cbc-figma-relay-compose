package com.droidcon.gatekey.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.droidcon.gatekey.textfield.State
import com.droidcon.gatekey.textfield.Style
import com.droidcon.gatekey.textfield.TextConfigurations
import com.droidcon.gatekey.textfield.materialIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GateKeyTextField(
    modifier: Modifier = Modifier,
    style: Style = Style.Outlined,
    state: State = State.Enabled,
    // textConfigurations is unused. Instead, M3 TextField determines its text configuration
    // by whether labelText and placeholderText are not empty.
    @Suppress("UNUSED_PARAMETER") textConfigurations: TextConfigurations = TextConfigurations.InputText,
    inputText: String = "",
    labelText: String = "",
    placeholderText: String = "",
    showSupportingText: Boolean = false,
    supportingText: String = "",
    showLeadingIcon: Boolean = false,
    leadingIcon: String = "search",
    showTrailingIcon: Boolean = false,
    trailingIcon: String = "cancel",
    onChange: (String) -> Unit = {}
) {
    val leadingIconText: @Composable (() -> Unit)? = if (showLeadingIcon) {
        {
            Text(leadingIcon, fontFamily = materialIcons)
        }
    } else null
    val trailingIconText: @Composable (() -> Unit)? = if (showTrailingIcon) {
        {
            Text(trailingIcon, fontFamily = materialIcons)
        }
    } else null

    when (style) {
        Style.Filled -> TextField(modifier = modifier,
            value = inputText,
            onValueChange = onChange,
            enabled = state != State.Disabled,
            label = { if (labelText.isNotEmpty()) Text(labelText) },
            placeholder = { if (placeholderText.isNotEmpty()) Text(placeholderText) },
            supportingText = { if (showSupportingText) Text(supportingText) },
            isError = state == State.Error,
            leadingIcon = leadingIconText,
            trailingIcon = trailingIconText,
        )
        Style.Outlined -> OutlinedTextField(modifier = modifier,
            value = inputText,
            onValueChange = onChange,
            enabled = state != State.Disabled,
            label = { if (labelText.isNotEmpty()) Text(labelText) },
            placeholder = { if (placeholderText.isNotEmpty()) Text(placeholderText) },
            supportingText = { if (showSupportingText) Text(supportingText) },
            isError = state == State.Error,
            leadingIcon = leadingIconText,
            trailingIcon = trailingIconText,
        )
    }
}