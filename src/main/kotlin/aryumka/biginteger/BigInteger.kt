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
