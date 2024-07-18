import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.ajailani.findyourcatscmp.ui.navigation.MainNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            MainNavigation()
        }
    }
}