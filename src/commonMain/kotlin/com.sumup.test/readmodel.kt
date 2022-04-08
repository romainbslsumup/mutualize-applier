package com.sumup.test

abstract class ReadModel(val storageId: String)

data class DailyStockReadModel(
    override var uuid: String,
    override var productId: Int = 0,
    override var quantity: Int = 0,
    override var criticalQuantity: Int = 0,
) : ReadModel(uuid), DailyStock

