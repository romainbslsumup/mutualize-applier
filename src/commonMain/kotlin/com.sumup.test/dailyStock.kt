package com.sumup.test

sealed interface DailyStock {
    val uuid: String
    val productId: Int
    val criticalQuantity: Int
    val quantity: Int
}

fun interface DailyStockApplier<in E : Event, R : DailyStock> {
    fun apply(event: E, model: R): Pair<R, StoreOperation>
}

fun saveOperationApplier() =
    DailyStockApplier { e: DailyStockEvent, m: DailyStock ->
        e.apply(m) to StoreOperation.Save
    }
