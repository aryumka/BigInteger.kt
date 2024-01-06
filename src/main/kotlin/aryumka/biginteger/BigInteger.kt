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

  override fun toString(): String = this.value
}
