package com.sumup.test

expect inline fun <reified T> keyOf(): String
expect fun <T: Any> keyOf(obj: T): String