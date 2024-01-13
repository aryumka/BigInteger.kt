# BigInteger.kt

## Why I implemented `BigInteger.kt` myself?
We are always told "Do not reinvent the wheel".

Still I've created this, which is obviously the opposite of the saying.
Because I believe sometimes the best way to learn is to build it from a scratch. 

BigInteger is like Integer but deals with very large numbers, mostly larger than Long type. 
Therefore it uses String when calculating so we don't have to worry about overflows. 

And as we all can expect, it's inevitably slower than any other number type calculations.
Taking that into an account, the BigInteger I've created takes O(n) for both addition and subtraction, for multiplication O(n^2) and lastly for division, in worst case, O(n^3) of time complexity. I took standard grade-school approaches(basically the one learn in elementary school).

## Features
- [x] Addition
- [x] Subtraction
- [x] Multiplication
- [x] Division
- [x] Modulo
- [x] Positive
- [x] Negative
- [x] Compare

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

## TODO
- [ ] Improve performance using karatsuba algorithm.

## License
MIT
