package com.sumup.test

interface Domain {
    val rootUUID: String
    val playhead: Int
}

data class DailyStockDomain(
    override val rootUUID: String,
    override val playhead: Int,
    override var uuid: String,
    override var productId: Int = 0,
    override var quantity: Int = 0,
    override var criticalQuantity: Int = 0,
) : Domain, DailyStock