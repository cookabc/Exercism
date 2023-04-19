package chessboard

// File represents a file on the chessboard, with a slice of bools indicating if each square is occupied.
type File []bool

// Chessboard represents the state of the chessboard, with a map of eight Files representing the files.
type Chessboard map[string]File

// CountInFile returns how many squares are occupied in the chessboard,
// within the given file.
func CountInFile(cb Chessboard, file string) int {
	// panic("Please implement CountInFile()")
	count := 0
	if fileSlice, ok := cb[file]; ok {
		for _, isOccupied := range fileSlice {
			if isOccupied {
				count++
			}
		}
	}
	return count
}

// CountInRank returns how many squares are occupied in the chessboard,
// within the given rank.
func CountInRank(cb Chessboard, rank int) int {
	// panic("Please implement CountInRank()")
	if rank < 1 || rank > 8 {
		return 0
	}

	count := 0
	for _, fileSlice := range cb {
		if fileSlice[rank-1] {
			count++
		}
	}
	return count
}

// CountAll should count how many squares are present in the chessboard.
func CountAll(cb Chessboard) int {
	// panic("Please implement CountAll()")
	count := 0
	for _, fileSlice := range cb {
		count += len(fileSlice)
	}
	return count
}

// CountOccupied returns how many squares are occupied in the chessboard.
func CountOccupied(cb Chessboard) int {
	// panic("Please implement CountOccupied()")
	count := 0
	for _, file := range cb {
		for _, occupied := range file {
			if occupied {
				count++
			}
		}
	}
	return count
}
