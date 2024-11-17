package ind.wl2d.deadlockhb.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import ind.wl2d.deadlockhb.HeadlineTextStyle
import ind.wl2d.deadlockhb.SubheadlineTextStyle
import ind.wl2d.deadlockhb.components.layouts.PageLayout
import ind.wl2d.deadlockhb.components.widgets.DefaultButton
import ind.wl2d.deadlockhb.toSitePalette

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HomeContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
}

enum class ItemCategoryState {
    WEAPONS,
    VITALITY,
    SPIRIT
}

private var categoryState by remember { mutableStateOf(ItemCategoryState.WEAPONS) }

@Composable
private fun CategoryListButtons(
    modifier: Modifier = Modifier,
) {
    DefaultButton(
        onClick = {
            categoryState = ItemCategoryState.WEAPONS
        },
        color = Colors.Orange,
        content = {
            Text("Weapons")
        }
    )
    DefaultButton(
        onClick = {
            categoryState = ItemCategoryState.VITALITY
        },
        color = Colors.Green,
        content = {
            Text("Vitality")
        }
    )
    DefaultButton(
        onClick = {
            categoryState = ItemCategoryState.SPIRIT
        },
        color = Colors.Purple,
        content = {
            Text("Spirit")
        }
    )
}

@Page
@Composable
fun HomePage() {
    PageLayout("Items") {
        Row(HomeContainerStyle.toModifier()) {
            Box {
                val sitePalette = ColorMode.current.toSitePalette()

                Column(
                    modifier = Modifier
                ) {
                    var categoryState by remember { mutableStateOf(ItemCategoryState.WEAPONS) }
                    // Buttons
                    Row(Modifier.gap(1.5.cssRem).displayIfAtLeast(Breakpoint.MD), verticalAlignment = Alignment.CenterVertically) {
                        CategoryListButtons()
                    }

                    Column {
                        Row {  }

                        Row {  }
                    }
                }
            }
        }
    }
}
