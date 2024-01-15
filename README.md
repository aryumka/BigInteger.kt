# BigInteger.kt

## Why I implemented `BigInteger.kt` myself?
We are always told "Do not reinvent the wheel".

Still I've created this, which is obviously the opposite of the saying.
Because I believe sometimes the best way to learn is to build it from a scratch. 

BigInteger is designed to handle large integer values that may exceed the range of built-in data types in Kotlin.
it basically uses String to deal with values so we don't have to worry about overflows. 

Taking that into account, as we all can expect, it's inevitably slower than any other number type calculations.
It takes O(n) for both addition and subtraction, for multiplication O(n^2) and lastly for division, in worst case, O(n^3) of time complexity(standard grade-school approaches).

## Features
- Arithmetic Operations: Addition, Subtraction, Multiplication, Division
- Comparison Operations: Equals, Greater Than, Less Than
- Conversion: From String, To String
- Immutable: Instances of BigIntegerKotlin are immutable, ensuring thread safety
  
## Usage
```kotlin
//create
val a = BigInteger.of("123456789012345678901234567890")
a.toString() // 123456789012345678901234567890
```

```kotlin
//comparison
val a = BigInteger.of(10_000_000_000)
val b = BigInteger.of(20_000_000_000)
println(a < b) // true
```

//addition
val a = BigInteger.of(10_000_000_000)
val b = BigInteger.of(20_000_000_000)
val c = a + b
println(c) // 30000000000
```
```kotlin
//subtraction
val a = BigInteger.of(10_000_000_000)
val b = BigInteger.of(20_000_000_000)
val c = a - b
println(c) // -10000000000
```
```kotlin
//multiplication
val a = BigInteger.of(10_000_000_000)
val b = BigInteger.of(20_000_000_000)
val c = a * b // 200000000000000000000
```
```kotlin
//division
val a = BigInteger.of(10_000_000_000)
val b = BigInteger.of(20_000_000_000)
val c = b / a // 2
```
```kotlin
//modulo
val a = BigInteger.of(20_000_000_000)
val b = BigInteger.of(10_000_000_000)
val c = a % b // 0
```
```kotlin
//positive
val a = BigInteger.of(10_000_000_000)
val b = +a
println(b) // 10000000000
```
```kotlin
//negative
val a = BigInteger.of(-10_000_000_000)
val b = -a // 10000000000
```

**Note: This BigIntegerKotlin class is inspired by the BigInteger class in Java
and is created for educational purposes. It may not cover all edge cases and
optimizations present in production-ready libraries.

## License
MIT
