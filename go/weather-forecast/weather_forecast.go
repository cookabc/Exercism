// Package weather contains forecasts.
package weather

// CurrentCondition : The current weather.
var CurrentCondition string

// CurrentLocation : The location of the weather.
var CurrentLocation string

// Forecast forecasts the weather for the city.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}