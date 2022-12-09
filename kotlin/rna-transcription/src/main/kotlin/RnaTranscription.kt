val rnaMap = mapOf(
    'A' to 'U',
    'C' to 'G',
    'G' to 'C',
    'T' to 'A'
)

fun transcribeToRna(dna: String): String = dna.map(rnaMap::get).joinToString("")
