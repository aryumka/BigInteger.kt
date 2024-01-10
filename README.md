# BigInteger.kt

## Features
- [x] Addition
- [x] Subtraction
- [x] Multiplication
- [x] Division
- [x] Modulo
- [x] Positive
- [x] Negative
- [x] Compare
- [ ] Power
- [ ] Augmented assignment

## Usage
```kotlin
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




## License
MIT
