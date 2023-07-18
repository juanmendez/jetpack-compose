import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardCheckBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        elevation = 10.dp,
        modifier = modifier
            .padding(15.dp)
            .background(Color.Gray),
        backgroundColor = MaterialTheme.colors.surface,
        content = content,
    )
}

@Preview
@Composable
fun CardCheckBoxPreview() {
    CardCheckBox {
        Text("hello")
    }
}