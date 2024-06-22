package com.industriousgnomes.model

import com.industriousgnomes.random.randomString

fun createAddress(
    street: String? = null,
    city: String? = null,
    state: String? = null,
    zipCode: String? = null,
): Address {
    return Address(
        street = street ?: randomString(),
        city = city ?: randomString(),
        state = state ?: randomString(),
        zipCode = zipCode ?: randomString(),
    )
}