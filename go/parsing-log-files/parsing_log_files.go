package parsinglogfiles

import (
	"fmt"
	"regexp"
	"strings"
)

func IsValidLine(text string) bool {
	// panic("Please implement the IsValidLine function")
	validPrefixes := []string{"[TRC]", "[DBG]", "[INF]", "[WRN]", "[ERR]", "[FTL]"}
	for _, prefix := range validPrefixes {
		if strings.HasPrefix(text, prefix) {
			return true
		}
	}
	return false
}

func SplitLogLine(line string) []string {
	separatorRegexp := regexp.MustCompile(`<[~*=+-]+>|<>`)
	// panic("Please implement the SplitLogLine function")
	fields := separatorRegexp.Split(line, -1)
	return fields
}

func CountQuotedPasswords(lines []string) int {
	// panic("Please implement the CountQuotedPasswords function")
	passwordRegexp := regexp.MustCompile(`"(?i:[^"]*password[^"]*)"`)
	count := 0
	for _, line := range lines {
		if passwordRegexp.MatchString(line) {
			count++
		}
	}
	return count
}

func RemoveEndOfLineText(text string) string {
	// panic("Please implement the RemoveEndOfLineText function")
	re := regexp.MustCompile(`end-of-line\d+`)
	return re.ReplaceAllString(text, "")
}

func TagWithUserName(lines []string) []string {
	// panic("Please implement the TagWithUserName function")
	taggedLines := make([]string, len(lines))
	lineReg := regexp.MustCompile(`User\s+([A-Za-z0-9]+)`)
	for i, line := range lines {
		if result := lineReg.FindStringSubmatch(line); result != nil {
			taggedLines[i] = fmt.Sprintf("[USR] %s %s", result[1], line)
		} else {
			taggedLines[i] = line
		}
	}
	return taggedLines
}
