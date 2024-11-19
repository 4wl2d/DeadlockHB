package ind.wl2d.deadlockhb.components.model

data class Hero(
    val id: Int,
    val name: String,
    val description: String,
    val imagePath: String? // Nullable image resource
)
