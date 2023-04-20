package logs

import "unicode/utf8"

// Application identifies the application emitting the given log.
func Application(log string) string {
	// panic("Please implement the Application() function")
	// Define a map of application characters to application names
	apps := map[rune]string{
		'❗': "recommendation",
		'🔍': "search",
		'☀': "weather",
	}

	// Iterate over each character in the log string
	for _, char := range log {
		// Check if the character is a known application character
		if app, ok := apps[char]; ok {
			return app
		}
	}

	// If no application character is found, return "default"
	return "default"
}

// Replace replaces all occurrences of old with new, returning the modified log
// to the caller.
func Replace(log string, oldRune, newRune rune) string {
	// panic("Please implement the Replace() function")
	// Convert the log string to a rune slice
	runes := []rune(log)

	// Iterate over each rune in the rune slice
	for i, r := range runes {
		// Check if the rune matches the old one
		if r == oldRune {
			// Replace the old character with the new value
			runes[i] = newRune
		}
	}

	// Convert the rune slice back to a string and return it
	return string(runes)
}

// WithinLimit determines whether or not the number of characters in log is
// within the limit.
func WithinLimit(log string, limit int) bool {
	// panic("Please implement the WithinLimit() function")
	return utf8.RuneCountInString(log) <= limit
}
