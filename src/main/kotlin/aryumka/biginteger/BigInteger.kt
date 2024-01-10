package aryumka.biginteger

class BigInteger(value: String) {
  val integer: String
  val sign: Sign

  init {
    if (value.isEmpty()) {
      throw IllegalArgumentException("value must not be empty")
    }
    if (!value.matches(Regex("^[+-]?[0-9_]+$"))) {
      throw IllegalArgumentException("value must be a number")
    }
    if (value.startsWith("-") || value.startsWith("+")) {
      this.integer = value.substring(1).replace("_", "")
      this.sign = if (value.startsWith("-")) Sign.NEGATIVE else Sign.POSITIVE
    } else {
      this.integer = value.replace("_", "")
      this.sign = Sign.POSITIVE
    }
  }

  // Factory methods
  companion object {
    fun of(value: String): BigInteger {
      return BigInteger(value)
    }

    fun of(value: Int): BigInteger {
      return BigInteger(value.toString())
    }

    fun of(value: Long): BigInteger {
      return BigInteger(value.toString())
    }
  }

  // Plus
  private fun plus(other: String): BigInteger {
    var result = ""
    var carry = 0
    var valueLength = this.integer.length - 1
    var otherLength = other.length - 1

    while (valueLength >= 0 || otherLength >= 0 || carry > 0) {
      val valueDigit = if (valueLength >= 0) this.integer[valueLength] - '0' else 0
      val otherDigit = if (otherLength >= 0) other[otherLength] - '0' else 0

      val sum = valueDigit + otherDigit + carry

      result += (sum % 10)
      carry = sum / 10

      valueLength--
      otherLength--
    }

    return BigInteger(result.reversed())
  }

  operator fun plus(other: Int): BigInteger =
    this.plus(other.toString())

  operator fun plus(other: Long): BigInteger =
    this.plus(other.toString())

  operator fun plus(other: BigInteger): BigInteger =
    this.plus(other.integer)



  // Minus
  operator fun minus(other: Int): BigInteger =
    this.minus(other.toString())

  operator fun minus(other: Long): BigInteger =
    this.minus(other.toString())

  operator fun minus(other: BigInteger): BigInteger =
    this.minus(other.integer)

  private fun minus(other: String): BigInteger {
    var result = ""
    var carry = 0

    //find out which is bigger
    var minuend = ""
    var subtrahend = ""
    var sign = ""

    if (this < BigInteger(other)) {
      minuend = other
      subtrahend = this.integer
      sign = "-"
    } else if (this > BigInteger(other)) {
      minuend = this.integer
      subtrahend = other
      sign = ""
    } else {
      return BigInteger("0")
    }

    var minuLength = minuend.length - 1
    var subLength = subtrahend.length - 1
    while (minuLength >= 0 || subLength >= 0 || carry > 0) {
      var minuDigit = if (minuLength >= 0) minuend[minuLength] - '0' else 0
      val subDigit = if (subLength >= 0) subtrahend[minuLength] - '0' else 0

      if (minuDigit < subDigit) {
        minuDigit += 10
      }

      val diff = minuDigit - subDigit - carry

      carry = if (minuDigit >= 10) {
        1
      } else {
        0
      }

      result += diff % 10

      minuLength--
      subLength--
    }

    return BigInteger(sign + result.reversed())
  }

  // Times
  operator fun times(other: Int): BigInteger =
    this.times(other.toString())

  operator fun times(other: Long): BigInteger =
    this.times(other.toString())

  operator fun times(other: BigInteger): BigInteger =
    this.times(other.toString())

  private fun times(other: String): BigInteger {
    var results = mutableListOf<String>()
    var carry = 0
    var valueLength = this.integer.length - 1
    var otherLength = other.length - 1

    var result = ""

    for (i in otherLength downTo 0) {
      val otherDigit = other[i] - '0'
      for (j in valueLength downTo 0) {
        val valueDigit = this.integer[j] - '0'

        val sum = valueDigit * otherDigit + carry

        result += (sum % 10)

        carry = sum / 10
      }
      if (carry > 0) {
        result += carry
        carry = 0
      }
      results.add(result.reversed())
      result = ""
    }

    return results.mapIndexed { index, s ->
      s.padEnd(s.length + index, '0')
    }.map { BigInteger(it) }.reduce { acc, bigInteger ->
      acc + bigInteger
    }
  }
  // Div
  operator fun div(other: Int): BigInteger =
    this.div(other.toString())

  operator fun div(other: Long): BigInteger =
    this.div(other.toString())

  operator fun div(other: BigInteger): BigInteger =
    this.div(other.toString())

  private fun div(other: String): BigInteger {
    var result = ""
    var sign = if (this.sign == BigInteger(other).sign) "" else "-"
    var remainder = BigInteger(this.integer)
    val divisor = BigInteger(other)

    if (other == "0") {
      throw ArithmeticException("Division by zero")
    }

    var count = 0
    while (remainder >= divisor * of(count + 1)) {
      count++
    }
    remainder -= divisor * of(count)
    result += count

    return BigInteger(sign + result)
  }

  // Rem
  operator fun rem(other: Int): BigInteger =
    this.rem(other.toString())

  operator fun rem(other: Long): BigInteger =
    this.rem(other.toString())

  operator fun rem(other: BigInteger): BigInteger =
    this.rem(other.toString())

  private fun rem(other: String): BigInteger {
    var sign = if (this.sign == BigInteger(other).sign) "" else "-"
    var remainder = BigInteger(this.integer)
    val divisor = BigInteger(other)

    if (other == "0") {
      throw ArithmeticException("Division by zero")
    }

    var count = 0
    while (remainder >= divisor * of(count + 1)) {
      count++
    }

    remainder -= divisor * of(count)

    return BigInteger(sign + remainder.integer)
  }

  // Unary
  operator fun unaryPlus(): BigInteger =
    this

  operator fun unaryMinus(): BigInteger =
    BigInteger(if (this.sign == Sign.POSITIVE) "-${this.integer}" else this.integer)

  override fun equals(other: Any?): Boolean =
    when (other) {
      is BigInteger -> this.toString() == other.toString()
      is String -> this.toString() == other
      is Int -> this.toString() == other.toString()
      is Long -> this.toString() == other.toString()
      else -> false
    }

  operator fun compareTo(other: BigInteger): Int =
    when {
      this.sign == Sign.POSITIVE && other.sign == Sign.NEGATIVE -> 1
      this.sign == Sign.NEGATIVE && other.sign == Sign.POSITIVE -> -1
      this.sign == Sign.POSITIVE && other.sign == Sign.POSITIVE -> {
        if (this.integer.length > other.integer.length) 1
        else if (this.integer.length < other.integer.length) -1
        else this.integer.compareTo(other.integer)
      }
      this.sign == Sign.NEGATIVE && other.sign == Sign.NEGATIVE -> {
        if (this.integer.length > other.integer.length) -1
        else if (this.integer.length < other.integer.length) 1
        else this.integer.compareTo(other.integer)
      }
      else -> 0
    }

  override fun toString(): String = if (this.sign == Sign.POSITIVE) this.integer else "-${this.integer}"

  enum class Sign {
    POSITIVE, NEGATIVE
  }
}
