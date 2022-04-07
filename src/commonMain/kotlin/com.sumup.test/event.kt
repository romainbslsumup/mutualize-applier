package com.sumup.test


sealed interface Event
data class DailyStocksItemCriticalQuantityWasSet(val quantity: Int) : Event

sealed interface StoreOperation {
    object Save: StoreOperation
}
