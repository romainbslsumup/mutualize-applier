package com.sumup.test


interface Event

sealed interface DailyStockEvent : Event {
    fun apply(dailyStock: DailyStock) : DailyStock
}

data class DailyStocksItemCriticalQuantityWasSet(val quantity: Int) : DailyStockEvent {
    override fun apply(dailyStock: DailyStock): DailyStock {
        return when(dailyStock) {
            is DailyStockDomain -> dailyStock.copy(criticalQuantity = quantity)
            is DailyStockReadModel -> dailyStock.copy(criticalQuantity = quantity)
        }
    }
}

sealed interface StoreOperation {
    object Save: StoreOperation
}
