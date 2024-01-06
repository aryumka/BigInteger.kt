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
    TODO()

  operator fun minus(other: Long): BigInteger =
    TODO()

  // Times
  operator fun times(other: Int): BigInteger =
    TODO()

  operator fun times(other: Long): BigInteger =
    TODO()

  // Div
  operator fun div(other: Int): BigInteger =
    TODO()

  operator fun div(other: Long): BigInteger =
    TODO()

  // Rem
  operator fun rem(other: Int): BigInteger =
    TODO()

  operator fun rem(other: Long): BigInteger =
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
