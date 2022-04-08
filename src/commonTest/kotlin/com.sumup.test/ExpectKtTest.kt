package com.sumup.test

import kotlin.test.Test

internal class ExpectKtTest {

    @Test
    fun test_applier() {
        val applier = saveOperationApplier()
        val event = DailyStocksItemCriticalQuantityWasSet(10)

        val inDomain = DailyStockDomain("rootUUID", 0, "uuid")
        println("inDomain: $inDomain")
        val inReadModel = DailyStockReadModel("uuid")
        println("inReadModel: $inReadModel")

        val domainDomainOperation = applier.apply(event, inDomain)
        println("updatedDomain: $inDomain")
        println("domainDomainOperation: $domainDomainOperation")

        val domainReadModelOperation = applier.apply(event, inReadModel)
        println("updatedReadModel: $inReadModel")
        println("domainReadModelOperation: $domainReadModelOperation")
    }
}