package partyrobot

import "strconv"
import "strings"

// Welcome greets a person by name.
func Welcome(name string) string {
	// panic("Please implement the Welcome function")
	return "Welcome to my party, " + name + "!"
}

// HappyBirthday wishes happy birthday to the birthday person and exclaims their age.
func HappyBirthday(name string, age int) string {
	// panic("Please implement the HappyBirthday function")
	return "Happy birthday " + name + "! You are now " + strconv.Itoa(age) + " years old!"
}

// AssignTable assigns a table to each guest.
func AssignTable(name string, table int, neighbor, direction string, distance float64) string {
	// panic("Please implement the AssignTable function")
	tableNumberString := strconv.Itoa(table)
	if len(tableNumberString) < 3 {
		tableNumberString = strings.Repeat("0", 3-len(tableNumberString)) + tableNumberString
	}
	return "Welcome to my party, " + name + "!\nYou have been assigned to table " + tableNumberString + ". Your table is " + direction + ", exactly " + strconv.FormatFloat(distance, 'f', 1, 64) + " meters from here.\nYou will be sitting next to " + neighbor + "."
}
