package com.nipunapps.moviedb.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.nipunapps.moviedb.R
import com.nipunapps.moviedb.core.noRippleClickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldFilled(
    modifier: Modifier = Modifier,
    value: String,
    hint: Int,
    backgroundColor : Color = MaterialTheme.colorScheme.onBackground,
    foregroundColor : Color = MaterialTheme.colorScheme.background,
    keyboardCategory: KeyboardCategory = KeyboardCategory.TEXT,
    onTextChange: (String) -> Unit
) {
    val passwordVisible = rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        TextField(
            value = value,
            onValueChange = onTextChange,
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            placeholder = {
                Text(
                    text = stringResource(id = hint),
                    style = MaterialTheme.typography.bodyMedium,
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = foregroundColor,
                containerColor = backgroundColor,
                cursorColor = MaterialTheme.colorScheme.primary,
                placeholderColor = foregroundColor.copy(alpha = 0.5f),
                disabledPlaceholderColor = foregroundColor.copy(alpha = 0.5f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(0.dp),
            trailingIcon = {
                if (keyboardCategory == KeyboardCategory.PASSWORD) {
                    val text = if (passwordVisible.value) R.string.hide_str else R.string.show_str
                    Text(
                        text = stringResource(id = text),
                        style = MaterialTheme.typography.titleSmall,
                        color = foregroundColor.copy(alpha = 0.7f),
                        modifier = Modifier
                            .noRippleClickable {
                                passwordVisible.value = !passwordVisible.value
                            }
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = when (keyboardCategory) {
                    KeyboardCategory.EMAIL -> KeyboardType.Email
                    KeyboardCategory.PASSWORD -> KeyboardType.Password
                    KeyboardCategory.PHONE -> KeyboardType.Number
                    else -> KeyboardType.Text
                }
            ),
            visualTransformation = if (keyboardCategory == KeyboardCategory.PASSWORD && !passwordVisible.value) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        )
    }
}

enum class KeyboardCategory {
    EMAIL,
    PHONE,
    TEXT,
    PASSWORD
}