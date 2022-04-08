package com.sumup.test

interface Domain {
    val rootUUID: String
    val playhead: Int
}

data class DailyStockDomain(
    override val rootUUID: String,
    override val playhead: Int,
    override val uuid: String,
    override val productId: Int = 0,
    override val quantity: Int = 0,
    override val criticalQuantity: Int = 0,
) : Domain, DailyStock