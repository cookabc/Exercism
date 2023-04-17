// Package weather provides functionality to forecast the current weather condition of various cities in Goblinocus.
// It defines global variables to store the current weather condition and location, and a function to update and retrieve the current weather condition for a specified city.
package weather

// CurrentCondition stores the current weather condition for the last city forecasted.
// This variable can be updated by calling the Forecast function.
// It can be accessed by any function in the package to retrieve the current weather condition.
var CurrentCondition string

// CurrentLocation stores the name of the last city forecasted.
// This variable can be updated by calling the Forecast function.
// It can be accessed by any function in the package to retrieve the current city name.
var CurrentLocation string

// Forecast takes a city and a weather condition as input, updates the global variables CurrentLocation and CurrentCondition with the specified values, and returns a string that concatenates the current location and condition.
// This function does not return an error if the specified city or condition is invalid or if there is an error while updating the global variables.
// It is the responsibility of the caller to ensure that the input is valid and that the global variables are updated correctly.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
