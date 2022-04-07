package com.sumup.test

interface Model

interface DailyStock : Model {
    val uuid: String
    val productId: Int
    val criticalQuantity: Int
    val quantity: Int

    // With Applier 2
    fun setCriticalQuantity(quantity: Int): DailyStock
}

fun interface DailyStockApplier<in E : Event, R : DailyStock> {
    fun apply(event: E, model: R): Pair<R, StoreOperation>
}

fun criticalQuantityWasSetReadModelApplier_1() =
    DailyStockApplier { e: DailyStocksItemCriticalQuantityWasSet, m: DailyStock ->
        val newModel = when (m) {
            is DailyStockDomain -> m.copy(criticalQuantity = e.quantity)
            is DailyStocksItemReadModel -> m.copy(criticalQuantity = e.quantity)
            else -> error("")
        }

        newModel to StoreOperation.Save
    }

fun criticalQuantityWasSetReadModelApplier_2() =
    DailyStockApplier { e: DailyStocksItemCriticalQuantityWasSet, m: DailyStock ->
        m.setCriticalQuantity(e.quantity) to StoreOperation.Save
    }
