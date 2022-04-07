package com.sumup.test

import kotlin.test.Test

internal class ExpectKtTest {

    fun test_applier(applier: DailyStockApplier<DailyStocksItemCriticalQuantityWasSet, DailyStock>) {
        val event = DailyStocksItemCriticalQuantityWasSet(10)

        val inDomain = DailyStockDomain("rootUUID", 0, "uuid")
        println("inDomain: $inDomain")
        val inReadModel = DailyStocksItemReadModel("uuid")
        println("inReadModel: $inReadModel")

        val (newDomain, domainDomainOperation) = applier.apply(event, inDomain)
        println("newDomain: $newDomain")
        println("domainDomainOperation: $domainDomainOperation")

        val (newReadModel, domainReadModelOperation) = applier.apply(event, inReadModel)
        println("newReadModel: $newReadModel")
        println("domainReadModelOperation: $domainReadModelOperation")
    }

    @Test
    fun test_applier_1() {
        test_applier(criticalQuantityWasSetReadModelApplier_1())
    }

    @Test
    fun test_applier_2() {
        test_applier(criticalQuantityWasSetReadModelApplier_2())
    }
}