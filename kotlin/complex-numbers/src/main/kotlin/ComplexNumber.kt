import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

    val abs: Double = sqrt(real * real + imag * imag)

    fun conjugate(): ComplexNumber {
        return ComplexNumber(real, -imag)
    }

    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real + other.real, imag + other.imag)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real - other.real, imag - other.imag)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        return ComplexNumber((real * other.real - imag * other.imag), (real * other.imag + imag * other.real))
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(
            (real * other.real + imag * other.imag) / (other.real * other.real + other.imag * other.imag),
            (imag * other.real - real * other.imag) / (other.real * other.real + other.imag * other.imag)
        )
    }
}

fun exponential(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(
        exp(complexNumber.real) * cos(complexNumber.imag),
        exp(complexNumber.real) * sin(complexNumber.imag)
    )
}
