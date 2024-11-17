package ind.wl2d.deadlockhb.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import ind.wl2d.deadlockhb.CircleButtonVariant
import ind.wl2d.deadlockhb.UncoloredButtonVariant
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    color: Color
) {
    Button(
        // when state in row
        onClick = { onClick() },
        modifier
            .width(178.px)
            .height(65.px)
            .backgroundColor(color)
            .onFocus {
                modifier
                    .border(
                        2.px
                    )
            }
    ) {
        content()
    }
}
