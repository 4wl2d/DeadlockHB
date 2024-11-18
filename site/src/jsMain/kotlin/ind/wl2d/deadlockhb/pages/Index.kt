package ind.wl2d.deadlockhb.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.BackgroundClip
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.CheckboxKind
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text
import ind.wl2d.deadlockhb.components.layouts.PageLayout
import ind.wl2d.deadlockhb.components.model.Item
import ind.wl2d.deadlockhb.components.widgets.DefaultButton
import ind.wl2d.deadlockhb.toSitePalette
import org.jetbrains.compose.web.css.px

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HomeContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
}

// states for item windows on center
enum class ItemCategoryState {
    WEAPONS,
    VITALITY,
    SPIRIT
}

@Composable
private fun CategoryListButtons(
    onCategoryChange: (ItemCategoryState) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth().gap(12.cssRem)
    ) {
        DefaultButton(
            onClick = { onCategoryChange(ItemCategoryState.WEAPONS) },
            color = Colors.Orange,
            content = { Text("Weapons") }
        )
        DefaultButton(
            onClick = { onCategoryChange(ItemCategoryState.VITALITY) },
            color = Colors.Green,
            content = { Text("Vitality") }
        )
        DefaultButton(
            onClick = { onCategoryChange(ItemCategoryState.SPIRIT) },
            color = Colors.Purple,
            content = { Text("Spirit") }
        )
    }
}

@Page
@Composable
fun HomePage(
    modifier: Modifier = Modifier
) {
    PageLayout("Items") {
        Row(HomeContainerStyle.toModifier()) {
            Box {
                val sitePalette = ColorMode.current.toSitePalette()

                var categoryState by remember { mutableStateOf(ItemCategoryState.WEAPONS) }

                Column(
                    modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                ) {
                    // Buttons
                    Row(modifier.gap(2.5.cssRem).displayIfAtLeast(Breakpoint.MD), verticalAlignment = Alignment.CenterVertically) {
                        // Pass state and onChange lambda to the child
                        CategoryListButtons(
                            onCategoryChange = { newCategory -> categoryState = newCategory }
                        )
                    }

                    Row (modifier.height(20.px)) {  }

                    when (categoryState) {
                        ItemCategoryState.WEAPONS -> WeaponsItemBox(modifier);
                        ItemCategoryState.VITALITY -> Text("vitality");
                        ItemCategoryState.SPIRIT -> Text("spirit");
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemsList(
    modifier: Modifier = Modifier,
    itemList: List<Item>
) {
    itemList.forEach { it ->
        Column(
            modifier.padding { 1.2.cssRem }
        ) {
            Text(it.price.toString())
            it.image
            Text(it.title)
        }
    }
}

@Composable
private fun WeaponsItemBox(
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxWidth()
    ) {
        Row(
            modifier
        ) {
            Box(
                modifier
                    .size(100.px)
                    .backgroundColor(Colors.Orange)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("500 souls")
            }
            ItemsList(
                modifier,
                listOf(
                    Item(1,1,null,"basic","weapons",false)
                )
            )
        }
        Row(

        ) {

        }
        Row(

        ) {

        }
        Row(

        ) {

        }
    }
}