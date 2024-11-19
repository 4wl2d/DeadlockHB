package ind.wl2d.deadlockhb.components.model

import org.w3c.dom.Image

data class Item(
    val id: Int,
    val price: Int,
    val image: Image?, // TODO: replace image to String and make it path
    val title: String,
    val category: String,
    val isActive: Boolean
)
