package booking

import (
	"fmt"
	"time"
)

// Schedule returns a time.Time from a string containing a date.
func Schedule(date string) time.Time {
	// panic("Please implement the Schedule function")
	layout := "1/2/2006 15:04:05"
	t, err := time.Parse(layout, date)
	if err != nil {
		panic(err)
	}
	return t
}

// HasPassed returns whether a date has passed.
func HasPassed(date string) bool {
	// panic("Please implement the HasPassed function")
	layout := "January 2, 2006 15:04:05"
	t, err := time.Parse(layout, date)
	if err != nil {
		panic(err)
	}
	now := time.Now()
	return t.Before(now)
}

// IsAfternoonAppointment returns whether a time is in the afternoon.
func IsAfternoonAppointment(date string) bool {
	// panic("Please implement the IsAfternoonAppointment function")
	layout := "Monday, January 2, 2006 15:04:05"
	t, err := time.Parse(layout, date)
	if err != nil {
		panic(err)
	}
	hour := t.Hour()
	return hour >= 12 && hour < 18
}

// Description returns a formatted string of the appointment time.
func Description(date string) string {
	// panic("Please implement the Description function")
	t := Schedule(date)
	dayOfWeek := t.Weekday().String()
	month := t.Month().String()
	day := t.Day()
	year := t.Year()
	hour := t.Hour()
	minute := t.Minute()
	return fmt.Sprintf("You have an appointment on %s, %s %d, %d, at %02d:%02d.", dayOfWeek, month, day, year, hour, minute)
}

// AnniversaryDate returns a Time with this year's anniversary.
func AnniversaryDate() time.Time {
	// panic("Please implement the AnniversaryDate function")
	return time.Date(time.Now().Year(), time.September, 15, 0, 0, 0, 0, time.UTC)
}
