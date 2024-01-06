package aryumka.biginteger

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BigIntegerTests: FunSpec({
  context("of Factory") {
    test("Int to BigInteger") {
      val bigInteger = BigInteger.of(1)

      bigInteger.toString() shouldBe "1"
    }

    test("BigInteger.of(1) == BigInteger.of(\"1\")") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of("1")

      bigInteger1 shouldBe bigInteger2
    }

    test("BigInteger.of(1) == BigInteger.of(1L)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(1L)

      bigInteger1 shouldBe bigInteger2
    }
  }

  context("plus operator") {
    test("BigInteger(1) + BigInteger(2) == BigInteger(3)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(2)
      val bigInteger3 = BigInteger.of(3)

      bigInteger1 + bigInteger2 shouldBe bigInteger3
    }

    test("Integer overflow") {
      val bigInteger1 = BigInteger.of(10_000_000_000)
      val bigInteger2 = BigInteger.of(20_000_000_000)

      bigInteger1 + bigInteger2 shouldBe "30000000000"
    }
  }
})
