object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> {
        var primes = (2..upperBound).toList()
        primes.forEach { primes = primes - ((it + it)..upperBound step it).toSet() }
        return primes
    }
}
