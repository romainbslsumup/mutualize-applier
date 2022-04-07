package com.sumup.test

import kotlin.reflect.typeOf

actual inline fun <reified T> keyOf(): String {
    return typeOf<T>().toString().split(".").takeLast(1).first()
}

actual fun <T: Any> keyOf(obj: T): String {
    return obj::class.qualifiedName?.split(".")?.takeLast(1)?.first()
        ?: error("It seems your are trying to get a key on an anonymous class.")
}