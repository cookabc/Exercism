fun translate(rna: String?): List<String> {
    val codonMap = mapOf(
        "AUG" to "Methionine",
        "UUU" to "Phenylalanine",
        "UUC" to "Phenylalanine",
        "UUA" to "Leucine",
        "UUG" to "Leucine",
        "UCU" to "Serine",
        "UCC" to "Serine",
        "UCA" to "Serine",
        "UCG" to "Serine",
        "UAU" to "Tyrosine",
        "UAC" to "Tyrosine",
        "UGU" to "Cysteine",
        "UGC" to "Cysteine",
        "UGG" to "Tryptophan",
        "UAA" to "STOP",
        "UAG" to "STOP",
        "UGA" to "STOP"
    )

    val proteinSequence = mutableListOf<String>()

    if (rna.isNullOrEmpty()) {
        return proteinSequence
    }

    for (i in rna.indices step 3) {
        if (i + 3 > rna.length) {
            throw IllegalArgumentException("Incomplete RNA sequence")
        }
        val codon = rna.substring(i, i + 3)
        val protein = codonMap[codon] ?: throw IllegalArgumentException("Invalid codon")
        if (protein == "STOP") {
            break
        }
        proteinSequence.add(protein)
    }

    return proteinSequence
}