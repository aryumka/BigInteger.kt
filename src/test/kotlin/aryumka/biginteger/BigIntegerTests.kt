package aryumka.biginteger

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

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

    test("BigInteger.of(1) == BigInteger.of(\"+1\")") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of("+1")

      bigInteger1 shouldBe bigInteger2
    }

    test("BigInteger.of(1) == BigInteger.of(\"-1\")") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of("-1")

      bigInteger1 shouldBe bigInteger2
    }

    test("BigInteger.of(\"foo\") throws IllegalArgumentException") {
      val exception = shouldThrow<IllegalArgumentException> {
        BigInteger.of("foo")
      }

      exception.message shouldBe "value must be a number"
    }

    test("BigInteger.of(\"\") throws IllegalArgumentException") {
      val exception = shouldThrow<IllegalArgumentException> {
        BigInteger.of("")
      }

      exception.message shouldBe "value must not be empty"
    }

    test("BigInteger.of(0)") {
      val bigInteger = BigInteger.of(0)

      bigInteger.toString() shouldBe "0"
      bigInteger.sign shouldBe BigInteger.Sign.POSITIVE
    }
  }

  context("equals") {
    test("BigInteger(1) == BigInteger(1)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(1)

      bigInteger1 shouldBe bigInteger2
    }

    test("BigInteger(1) == BigInteger(1L)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(1L)

      bigInteger1 shouldBe bigInteger2
    }

    test("BigInteger(1) == BigInteger(\"1\")") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of("1")

      bigInteger1 shouldBe bigInteger2
    }
  }

  context("compareTo") {
    test("BigInteger(1) < BigInteger(2)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(2)

      (bigInteger1 < bigInteger2) shouldBe true
    }

    test("BigInteger(1) > BigInteger(-2)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(-2)

      (bigInteger1 > bigInteger2) shouldBe true
    }
  }

  context("plus operator") {
    test("BigInteger(1) + BigInteger(2) == BigInteger(3)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(2)
      val bigInteger3 = BigInteger.of(3)

      bigInteger1 + bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(1L) + BigInteger(2L) == BigInteger(3)") {
      val bigInteger1 = BigInteger.of(1L)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(3)

      bigInteger1 + bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(1) + BigInteger(2L) == BigInteger(3)") {
      val bigInteger1 = BigInteger.of(1)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(3)

      bigInteger1 + bigInteger2 shouldBe bigInteger3
    }

    test("Integer overflow") {
      val bigInteger1 = BigInteger.of(10_000_000_000)
      val bigInteger2 = BigInteger.of(20_000_000_000)

      bigInteger1 + bigInteger2 shouldBe "30000000000"
    }
  }

  context("minus operator") {
    test("BigInteger(3) - BigInteger(2) == BigInteger(1)") {
      val bigInteger1 = BigInteger.of(3)
      val bigInteger2 = BigInteger.of(2)
      val bigInteger3 = BigInteger.of(1)

      bigInteger1 - bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(3) - BigInteger(2L) == BigInteger(1)") {
      val bigInteger1 = BigInteger.of(3)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(1)

      bigInteger1 - bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(15) - BigInteger(9) == BigInteger(6)") {
      val bigInteger1 = BigInteger.of(15)
      val bigInteger2 = BigInteger.of(9)
      val bigInteger3 = BigInteger.of(6)

      bigInteger1 - bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(9) - BigInteger(15) == BigInteger(-6)") {
      val bigInteger1 = BigInteger.of(9)
      val bigInteger2 = BigInteger.of(15)
      val bigInteger3 = BigInteger.of(-6)

      bigInteger1 - bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(3L) - BigInteger(2L) == BigInteger(1)") {
      val bigInteger1 = BigInteger.of(3L)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(1)

      bigInteger1 - bigInteger2 shouldBe bigInteger3
    }
  }

  context("times operator") {
    test("BigInteger(3) * BigInteger(2) == BigInteger(6)") {
      val bigInteger1 = BigInteger.of(3)
      val bigInteger2 = BigInteger.of(2)
      val bigInteger3 = BigInteger.of(6)

      bigInteger1 * bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(3) * BigInteger(2L) == BigInteger(6)") {
      val bigInteger1 = BigInteger.of(3)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(6)

      bigInteger1 * bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(3L) * BigInteger(2L) == BigInteger(6)") {
      val bigInteger1 = BigInteger.of(3L)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(6)

      bigInteger1 * bigInteger2 shouldBe bigInteger3
    }
  }

  context("div operator") {
    test("BigInteger(6) / BigInteger(2) == BigInteger(3)") {
      val bigInteger1 = BigInteger.of(6)
      val bigInteger2 = BigInteger.of(2)
      val bigInteger3 = BigInteger.of(3)

      bigInteger1 / bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(6) / BigInteger(2L) == BigInteger(3)") {
      val bigInteger1 = BigInteger.of(6)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(3)

      bigInteger1 / bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(6L) / BigInteger(2L) == BigInteger(3)") {
      val bigInteger1 = BigInteger.of(6L)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(3)

      bigInteger1 / bigInteger2 shouldBe bigInteger3
    }
  }

  context("mod operator") {
    test("BigInteger(6) % BigInteger(2) == BigInteger(0)") {
      val bigInteger1 = BigInteger.of(6)
      val bigInteger2 = BigInteger.of(2)
      val bigInteger3 = BigInteger.of(0)

      bigInteger1 % bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(6) % BigInteger(4L) == BigInteger(2)") {
      val bigInteger1 = BigInteger.of(6)
      val bigInteger2 = BigInteger.of(4L)
      val bigInteger3 = BigInteger.of(2)

      bigInteger1 % bigInteger2 shouldBe bigInteger3
    }

    test("BigInteger(6L) % BigInteger(2L) == BigInteger(0)") {
      val bigInteger1 = BigInteger.of(6L)
      val bigInteger2 = BigInteger.of(2L)
      val bigInteger3 = BigInteger.of(0)

      bigInteger1 % bigInteger2 shouldBe bigInteger3
    }
  }
})
