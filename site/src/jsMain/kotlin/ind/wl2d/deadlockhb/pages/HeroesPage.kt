package ind.wl2d.deadlockhb.pages

import androidx.compose.runtime.Composable
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
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
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
import ind.wl2d.deadlockhb.components.model.Hero
import ind.wl2d.deadlockhb.toSitePalette

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
}

@Page(routeOverride = "/heroes")
@Composable
fun HeroesPage() {
    PageLayout("Heroes") {
        Row(HeroContainerStyle.toModifier()) {
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.px)
                        .border(2.px)
                        .borderRadius(20.px)
                        .background(Colors.LightGray)
                ) {
                    // Create rows of hero cards (3 heroes per row)
                    for (rowIndex in heroes.indices step 3) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            for (columnIndex in 0 until 3) {
                                val heroIndex = rowIndex + columnIndex
                                if (heroIndex < heroes.size) {
                                    HeroCard(heroes[heroIndex], Modifier.weight(1f))
                                } else {
                                }
                                Column(modifier = Modifier.width(2.px)) {} // Spacer
                            }
                        }
                        Row(modifier = Modifier.height(2.px)) {} // Spacer
                    }
                }
            }
        }
    }
}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Colors.Gray)
            .border(2.px)
            .borderRadius(8.px)
            .padding(16.px)
    ) {
        Box(
            modifier = Modifier
                .size(60.px)
                .border(2.px)
                .borderRadius(2000.px)
                .background(Colors.Gray),
            contentAlignment = Alignment.Center
        ) {
            // TODO: Placeholder for the image
        }
        Box(
            modifier = Modifier
                .border(2.px)
                .borderRadius(12.px)
                .background(Colors.Gray),
            contentAlignment = Alignment.Center
        ) {
            // name
            Text(
                hero.name
            )
        }
        Box(
            modifier = Modifier
                .border(2.px)
                .borderRadius(12.px)
                .background(Colors.Gray),
            contentAlignment = Alignment.Center
        ) {
            // description
            Text(
                hero.description
            )
        }
    }
}

// Global list of heroes with IDs and null images
val heroes = listOf(
    Hero(1, "Abrams", "Charges into close combat", null),
    Hero(2, "Bebop", "Hooks an enemy for a knockout", null),
    Hero(3, "Dynamo", "Locks down the enemy team", null),
    Hero(4, "Grey Talon", "Delivers long range skill-shots", null),
    Hero(5, "Haze", "Sneaks in and sprays bullets", null),
    Hero(6, "Holliday", "Unreleased", null),
    Hero(7, "Infernus", "Lights up enemies and watches them burn", null),
    Hero(8, "Ivy", "Set up a power duo with a lethal bloom", null),
    Hero(9, "Kelvin", "Freezes enemies in their tracks", null),
    Hero(10, "Lady Geist", "Sacrifices health then drains life", null),
    Hero(11, "Lash", "Dives down to stomp his foes", null),
    Hero(12, "McGinnis", "Controls the battle with counterfire", null),
    Hero(13, "Mirage", "Times his shots and catches enemies off guard", null),
    Hero(14, "Mo & Krill", "Burrows underneath his enemies", null),
    Hero(15, "Paradox", "Manipulates Space and Time", null),
    Hero(16, "Pocket", "Infiltrates and disrupts the enemy", null),
    Hero(17, "Seven", "Electrocutes crowds of enemies", null),
    Hero(18, "Shiv", "Bleeds out foes, then goes in for the kill", null),
    Hero(19, "Vindicta", "Snipes the unsuspecting", null),
    Hero(20, "Viscous", "Rolls around deflecting bullets", null),
    Hero(21, "Warden", "Weakens his enemies and chains them", null),
    Hero(22, "Wraith", "Melts isolated targets", null),
    Hero(23, "Yamato", "Delivers charged attacks with precision", null),
)