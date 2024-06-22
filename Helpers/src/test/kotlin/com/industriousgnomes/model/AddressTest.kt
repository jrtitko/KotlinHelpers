package com.industriousgnomes.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class AddressTest : FunSpec ({

    test("Create a random address (testFixture)") {
        val address = createAddress()
        with (address) {
            street.shouldNotBeNull()
            city.shouldNotBeNull()
            state.shouldNotBeNull()
            zipCode.shouldNotBeNull()
        }
    }

    test("Create an address with overrides (testFixture)") {
        val street = "123 Main St"
        val city = "Chicago"
        val state = "IL"
        val zipCode = "12345"

        val address = createAddress(
            street = street,
            city = city,
            state = state,
            zipCode = zipCode,
        )

        address.street shouldBe street
        address.city shouldBe city
        address.state shouldBe state
        address.zipCode shouldBe zipCode
    }
})