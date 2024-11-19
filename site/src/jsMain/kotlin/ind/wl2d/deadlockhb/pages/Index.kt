package ind.wl2d.deadlockhb.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSColor
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.dom.Text
import ind.wl2d.deadlockhb.components.layouts.PageLayout
import ind.wl2d.deadlockhb.components.model.Item
import ind.wl2d.deadlockhb.components.widgets.DefaultButton
import ind.wl2d.deadlockhb.toSitePalette
import org.jetbrains.compose.web.css.*

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
                        ItemCategoryState.VITALITY -> VitalityItemBox(modifier);
                        ItemCategoryState.SPIRIT -> SpiritItemBox(modifier);
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemsList(
    modifier: Modifier = Modifier,
    color: Color,
    itemList: List<Item>
) {
    itemList.forEach {
        Column( // Vertical spacer
            modifier
                .width(8.px)
                .fillMaxHeight()
        ) {  }
        ItemCard(modifier, color, it)
    }
}

@Composable
private fun ItemCard(
    modifier: Modifier = Modifier,
    color: Color,
    item: Item
) {
    Column(
        modifier = modifier
            .width(100.px)
            .height(120.px)
            .border(2.px, style = LineStyle.Solid, color = color)
            .borderRadius(12.px),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .border(2.px)
                .borderRadius(8.px)
                .backgroundColor(color),
            contentAlignment = Alignment.Center
        ) {
            // Item Price
            Text(
                "$${item.price}"
            )
        }
        Box(
            modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            // Item image
            item.image
        }
        Box(
            modifier
                .fillMaxWidth()
                .border(2.px)
                .borderRadius(12.px),
            contentAlignment = Alignment.Center
        ) {
            // Item Title
            Text(
                item.title
            )
        }
    }
}

@Composable
private fun VitalityItemBox(
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxWidth()
            .gap(1.2.cssRem)
    ) {
        Row( // 500 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.Green)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("500 souls")
            }
            ItemsList(
                modifier,
                Colors.Green,
                sampleVitalityItems500 // Updated to vitality items
            )
        }
        Row( // 1250 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.Green)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("1250 souls")
            }
            ItemsList(
                modifier,
                Colors.Green,
                sampleVitalityItems1250 // Updated to vitality items
            )
        }
        Row( // 3000 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.Green)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("3000 souls")
            }
            ItemsList(
                modifier,
                Colors.Green,
                sampleVitalityItems3000 // Updated to vitality items
            )
        }
        Row( // 6200 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.Green)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("6200 souls")
            }
            ItemsList(
                modifier,
                Colors.Green,
                sampleVitalityItems6200 // Updated to vitality items
            )
        }
    }
}

@Composable
private fun SpiritItemBox(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxWidth()
            .gap(1.2.cssRem)
    ) {
        Row( // 500 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.MediumOrchid) // Updated to Spirit theme color
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("500 souls")
            }
            ItemsList(
                modifier,
                Colors.MediumOrchid, // Updated to Spirit theme color
                sampleSpiritItems500 // Updated to Spirit items
            )
        }
        Row( // 1250 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.MediumOrchid) // Updated to Spirit theme color
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("1250 souls")
            }
            ItemsList(
                modifier,
                Colors.MediumOrchid, // Updated to Spirit theme color
                sampleSpiritItems1250 // Updated to Spirit items
            )
        }
        Row( // 3000 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.MediumOrchid) // Updated to Spirit theme color
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("3000 souls")
            }
            ItemsList(
                modifier,
                Colors.MediumOrchid, // Updated to Spirit theme color
                sampleSpiritItems3000 // Updated to Spirit items
            )
        }
        Row( // 6200 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.MediumOrchid) // Updated to Spirit theme color
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("6200 souls")
            }
            ItemsList(
                modifier,
                Colors.MediumOrchid, // Updated to Spirit theme color
                sampleSpiritItems6200 // Updated to Spirit items
            )
        }
    }
}


@Composable
private fun WeaponsItemBox(
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxWidth()
            .gap(1.2.cssRem)
    ) {
        Row( // 500 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.SandyBrown)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("500 souls")
            }
            ItemsList(
                modifier,
                Colors.SandyBrown,
                sampleWeaponItems500
            )
        }
        Row( // 1250 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.SandyBrown)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("1250 souls")
            }
            ItemsList(
                modifier,
                Colors.SandyBrown,
                sampleWeaponItems1250
            )
        }
        Row( // 3000 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.SandyBrown)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("3000 souls")
            }
            ItemsList(
                modifier,
                Colors.SandyBrown,
                sampleWeaponItems3000
            )
        }
        Row( // 6200 souls items
            modifier
                .border(2.px)
                .borderRadius(12.px)
        ) {
            Box(
                modifier
                    .size(120.px)
                    .backgroundColor(Colors.SandyBrown)
                    .border(2.px)
                    .borderRadius(12.px),
                contentAlignment = Alignment.Center
            ) {
                Text("6200 souls")
            }
            ItemsList(
                modifier,
                Colors.SandyBrown,
                sampleWeaponItems6200
            )
        }
    }
}

val sampleWeaponItems500 = listOf(
    Item(1, 500, null, "Basic Magazine", "weapons", false),
    Item(2, 500, null, "Close Quarters", "weapons", false),
    Item(3, 500, null, "Headshot Booster", "weapons", false),
    Item(4, 500, null, "High-Velocity Mag", "weapons", false),
    Item(5, 500, null, "Hollow Point Ward", "weapons", false),
)

val sampleWeaponItems1250 = listOf(
    Item(6, 1250, null, "Active Reload", "weapons", false),
    Item(7, 1250, null, "Berserker", "weapons", false),
    Item(8, 1250, null, "Fleetfoot", "weapons", true),
    Item(9, 1250, null, "Kinetic Dash", "weapons", true),
    Item(10, 1250, null, "Long Range", "weapons", false)
)

val sampleWeaponItems3000 = listOf(
    Item(11, 3000, null, "Alchemical Fire", "weapons", true),
    Item(12, 3000, null, "Burst Fire", "weapons", false),
    Item(13, 3000, null, "Escalating Resilience", "weapons", false),
    Item(14, 3500, null, "Headhunter", "weapons", true),
    Item(15, 3000, null, "Heroic Aura", "weapons", true),
    Item(16, 3000, null, "Tesla Bullets", "weapons", false),
    Item(17, 3500, null, "Titanic Magazine", "weapons", false)
)

val sampleWeaponItems6200 = listOf(
    Item(18, 6200, null, "Crippling Headshot", "weapons", true),
    Item(19, 6200, null, "Frenzy", "weapons", true),
    Item(20, 7450, null, "Silencer", "weapons", true)
)

val sampleVitalityItems500 = listOf(
    Item(1, 500, null, "Enduring Spirit", "vitality", false),
    Item(2, 500, null, "Extra Health", "vitality", false),
    Item(3, 500, null, "Extra Regen", "vitality", false),
    Item(4, 500, null, "Extra Stamina", "vitality", false),
    Item(5, 500, null, "Healing Rite", "vitality", true),
    Item(6, 500, null, "Melee Lifesteal", "vitality", false),
    Item(7, 500, null, "Sprint Boots", "vitality", false)
)

val sampleVitalityItems1250 = listOf(
    Item(8, 1250, null, "Bullet Armor", "vitality", false),
    Item(9, 1250, null, "Bullet Lifesteal", "vitality", false),
    Item(10, 1250, null, "Combat Barrier", "vitality", false),
    Item(11, 1250, null, "Debuff Reducer", "vitality", false),
    Item(12, 1250, null, "Divine Barrier", "vitality", true),
    Item(13, 1250, null, "Enchanter's Barrier", "vitality", false),
    Item(14, 1250, null, "Healbane", "vitality", false),
    Item(15, 1250, null, "Healing Booster", "vitality", false),
//    Item(16, 1250, null, "Reactive Barrier", "vitality", false),
//    Item(17, 1250, null, "Restorative Locket", "vitality", true),
//    Item(18, 1250, null, "Return Fire", "vitality", true),
//    Item(19, 1250, null, "Spirit Armor", "vitality", false),
//    Item(20, 1250, null, "Spirit Lifesteal", "vitality", false),
//    Item(21, 1750, null, "Enduring Speed", "vitality", false),
//    Item(22, 1750, null, "Healing Nova", "vitality", true)
)

val sampleVitalityItems3000 = listOf(
    Item(23, 3000, null, "Majestic Leap", "vitality", true),
    Item(24, 3000, null, "Metal Skin", "vitality", true),
    //Item(25, 3000, null, "Rescue Beam", "vitality", true),
    Item(26, 3000, null, "Superior Stamina", "vitality", false),
    Item(27, 3000, null, "Veil Walker", "vitality", false),
    Item(28, 3500, null, "Fortitude", "vitality", false),
    Item(29, 3500, null, "Improved Bullet Armor", "vitality", false),
    //Item(30, 3500, null, "Lifestrike", "vitality", true),
    //Item(31, 4250, null, "Debuff Remover", "vitality", true),
    Item(32, 4250, null, "Improved Spirit Armor", "vitality", false)
)

val sampleVitalityItems6200 = listOf(
    Item(33, 6200, null, "Colossus", "vitality", true),
    Item(34, 6200, null, "Inhibitor", "vitality", false),
    Item(35, 6200, null, "Leech", "vitality", true),
    Item(36, 6200, null, "Phantom Strike", "vitality", true),
    Item(37, 6200, null, "Siphon Bullets", "vitality", true),
    Item(38, 6200, null, "Unstoppable", "vitality", true)
)

// Spirit Items for 500 souls
val sampleSpiritItems500 = listOf(
    Item(1, 500, null, "Ammo Scavenger", "spirit", false),
    Item(2, 500, null, "Extra Charge", "spirit", false),
    Item(3, 500, null, "Extra Spirit", "spirit", false),
    Item(4, 500, null, "Infuser", "spirit", true),
    Item(5, 500, null, "Mystic Burst", "spirit", false),
    Item(6, 500, null, "Mystic Reach", "spirit", false),
    Item(7, 500, null, "Spirit Strike", "spirit", false)
)

// Spirit Items for 1250 souls
val sampleSpiritItems1250 = listOf(
    Item(8, 1250, null, "Bullet Resist Shredder", "spirit", false),
    Item(9, 1250, null, "Cold Front", "spirit", true),
    Item(10, 1250, null, "Decay", "spirit", true),
    Item(11, 1250, null, "Duration Extender", "spirit", false),
    Item(12, 1250, null, "Improved Cooldown", "spirit", false),
    Item(13, 1250, null, "Mystic Vulnerability", "spirit", false),
    //Item(14, 1250, null, "Quicksilver Reload", "spirit", false),
    //Item(15, 1250, null, "Slowing Hex", "spirit", true),
    Item(16, 1250, null, "Suppressor", "spirit", false),
    Item(17, 1250, null, "Withering Whip", "spirit", true)
)

// Spirit Items for 3000 souls
val sampleSpiritItems3000 = listOf(
    Item(18, 3000, null, "Ethereal Shift", "spirit", true),
    Item(19, 3000, null, "Surge of Power", "spirit", false),
    Item(20, 3000, null, "Knockdown", "spirit", true),
    //Item(21, 3000, null, "Silence Glyph", "spirit", true),
    //Item(22, 3500, null, "Improved Burst", "spirit", false),
    Item(23, 3500, null, "Improved Reach", "spirit", false),
    Item(24, 3500, null, "Improved Spirit", "spirit", false),
    Item(25, 3500, null, "Rapid Recharge", "spirit", true),
    Item(26, 4250, null, "Superior Cooldown", "spirit", false),
    Item(27, 4250, null, "Superior Duration", "spirit", false)
)

// Spirit Items for 6200 souls
val sampleSpiritItems6200 = listOf(
    Item(28, 6200, null, "Curse", "spirit", true),
    Item(29, 6200, null, "Diviner's Kevlar", "spirit", false),
    Item(30, 6200, null, "Echo Shard", "spirit", true),
    Item(31, 6200, null, "Escalating Exposure", "spirit", false),
    Item(32, 6200, null, "Magic Carpet", "spirit", true),
    Item(33, 6200, null, "Mystic Reverb", "spirit", false),
    Item(34, 6200, null, "Refresher", "spirit", true),
    Item(35, 9700, null, "Boundless Spirit", "spirit", false)

)
