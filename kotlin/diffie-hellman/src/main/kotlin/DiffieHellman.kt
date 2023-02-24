import java.math.BigInteger
import java.util.*

object DiffieHellman {

    fun privateKey(prime: BigInteger): BigInteger {
        var key = prime
        while (key < BigInteger.ONE || key >= prime) {
            key = BigInteger(prime.bitLength(), Random())
        }
        return key
    }

    fun publicKey(p: BigInteger, g: BigInteger, privKey: BigInteger): BigInteger {
        return g.modPow(privKey, p)
    }

    fun secret(prime: BigInteger, publicKey: BigInteger, privateKey: BigInteger): BigInteger {
        return publicKey.modPow(privateKey, prime)
    }
}
