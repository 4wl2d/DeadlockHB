package ind.wl2d.deadlockhb.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Span
import ind.wl2d.deadlockhb.toSitePalette

val FooterStyle = CssStyle.base {
    Modifier
        .backgroundColor(colorMode.toSitePalette().nearBackground)
        .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Row(
        FooterStyle.toModifier().then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(contentAlignment = Alignment.Center) {
            Span(Modifier.textAlign(TextAlign.Center).toAttrs()) {
                val sitePalette = ColorMode.current.toSitePalette()
                SpanText("Built with ")
                Link(
                    "https://github.com/varabyte/kobweb",
                    "Kobweb",
                    Modifier.setVariable(ColorVar, sitePalette.brand.primary),
                    variant = UncoloredLinkVariant
                )
                SpanText(", designed by ")
                Link(
                    "https://github.com/4wl2d",
                    "4wl2d",
                    Modifier.setVariable(ColorVar, sitePalette.brand.accent).whiteSpace(WhiteSpace.NoWrap),
                    variant = UncoloredLinkVariant
                )
            }
        }
        Box(contentAlignment = Alignment.Center) {
            Span(Modifier.textAlign(TextAlign.Center).toAttrs()) {
                val sitePalette = ColorMode.current.toSitePalette()
                SpanText("email: ")
                Link(
                    "",
                    "loki.lafeyson.00@list.ru",
                    Modifier.setVariable(ColorVar, sitePalette.brand.primary),
                    variant = UncoloredLinkVariant
                )
            }
        }
    }
}
