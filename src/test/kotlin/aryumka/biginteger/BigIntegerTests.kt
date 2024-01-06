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
})
