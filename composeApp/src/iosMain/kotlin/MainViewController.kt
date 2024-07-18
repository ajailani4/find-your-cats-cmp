import androidx.compose.ui.window.ComposeUIViewController
import com.ajailani.findyourcatscmp.di.KoinInitializer

fun MainViewController() = ComposeUIViewController(
    configure = { KoinInitializer().init() }
) {
    App()
}