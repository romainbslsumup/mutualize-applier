package com.sumup.test

interface Model

interface DailyStock : Model {
    var uuid: String
    var productId: Int
    var criticalQuantity: Int
    var quantity: Int
}

fun interface DailyStockApplier<in E : Event, R : DailyStock> {
    fun apply(event: E, model: R): StoreOperation
}

fun criticalQuantityWasSetReadModelApplier() =
    DailyStockApplier { e: DailyStocksItemCriticalQuantityWasSet, m: DailyStock ->
        m.criticalQuantity = e.quantity
        StoreOperation.Save
    }
