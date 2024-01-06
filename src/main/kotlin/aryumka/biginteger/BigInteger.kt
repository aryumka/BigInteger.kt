package aryumka.biginteger

class BigInteger(
  private val value: String
) {
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
    var valueLength = this.value.length - 1
    var otherLength = other.length - 1

    while (valueLength >= 0 || otherLength >= 0 || carry > 0) {
      val valueDigit = if (valueLength >= 0) this.value[valueLength] - '0' else 0
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
    this.plus(other.value)



  // Minus
  operator fun minus(other: Int): BigInteger =
    this.minus(other.toString())

  operator fun minus(other: Long): BigInteger =
    this.minus(other.toString())

  operator fun minus(other: BigInteger): BigInteger =
    this.minus(other.value)

  private fun minus(other: String): BigInteger {
    var result = ""
    var carry = 0

    //find out which is bigger
    var minuend = ""
    var subtrahend = ""
    if (this.value.length > other.length) {
      minuend = this.value
      subtrahend = other
    } else if (this.value.length < other.length) {
      minuend = other
      subtrahend = this.value
    } else {
      //same length
      if (this.value > other) {
        minuend = this.value
        subtrahend = other
      } else {
        minuend = other
        subtrahend = this.value
      }
    }

    var valueLength = minuend.length - 1
    var otherLength = subtrahend.length - 1
    while (valueLength >= 0 || otherLength >= 0 || carry > 0) {
      var valueDigit = if (valueLength >= 0) this.value[valueLength] - '0' else 0
      val otherDigit = if (otherLength >= 0) other[otherLength] - '0' else 0

      if (valueDigit < otherDigit) {
        valueDigit += 10
      }

      val diff = valueDigit - otherDigit - carry

      if (valueDigit >= 10) {
        carry = 1
      } else {
        carry = 0
      }

      result += if (diff % 10 > 0) diff % 10 else ""

      valueLength--
      otherLength--
    }

    return BigInteger(result.reversed())
  }

  // Times
  operator fun times(other: Int): BigInteger =
    TODO()

  operator fun times(other: Long): BigInteger =
    TODO()

  operator fun times(other: BigInteger): BigInteger =
    TODO()

  // Div
  operator fun div(other: Int): BigInteger =
    TODO()

  operator fun div(other: Long): BigInteger =
    TODO()

  operator fun div(other: BigInteger): BigInteger =
    TODO()

  // Rem
  operator fun rem(other: Int): BigInteger =
    TODO()

  operator fun rem(other: Long): BigInteger =
    TODO()

  operator fun rem(other: BigInteger): BigInteger =
    TODO()

  override fun equals(other: Any?): Boolean =
    when (other) {
      is BigInteger -> this.value == other.value
      is String -> this.value == other
      is Int -> this.value == other.toString()
      is Long -> this.value == other.toString()
      else -> false
    }

  override fun toString(): String = this.value
}
