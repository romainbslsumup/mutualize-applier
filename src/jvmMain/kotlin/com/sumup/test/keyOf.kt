package com.sumup.test

actual inline fun <reified T> keyOf(): String {
    return T::class.java.simpleName
}

actual fun <T: Any> keyOf(obj: T): String {
    return obj::class.java.simpleName
}