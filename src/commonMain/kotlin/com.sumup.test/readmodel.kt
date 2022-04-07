package com.sumup.test

data class DailyStocksItemReadModel(
    override val uuid: String,
    override val productId: Int = 0,
    override val quantity: Int = 0,
    override val criticalQuantity: Int = 0,
) : ReadModel(uuid), DailyStock {
    override fun setCriticalQuantity(quantity: Int) = copy(criticalQuantity = quantity)
}

abstract class ReadModel(val storageId: String)
