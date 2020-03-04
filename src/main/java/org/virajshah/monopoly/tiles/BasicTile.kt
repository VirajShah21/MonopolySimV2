package org.virajshah.monopoly.tiles

class BasicTile : Tile {
    constructor(name: String, attributes: List<TileAttribute?>) : super(name, attributes)

    constructor(name: String, attributes: Array<TileAttribute?>) : super(name, attributes)

    constructor(name: String, attribute: TileAttribute?) : super(name, attribute)
}