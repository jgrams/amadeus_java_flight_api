# Welcome!

This app is an example of how to use the [Amadeus](https://amadeus.com/) Flight APIs to find and book a flight!

To see how the app was built, read Part One [here](https://developers.amadeus.com/blog/flight-booking-application-java-spring-react-1), and Part Two [here](https://developers.amadeus.com/blog/flight-booking-application-java-spring-react-2).

## Requirements

You'll need:
- A text editor or IDE
- JDK 1.8 or later
- Maven 3.2+
- A recent version of NPM and Node.JS

API Access:
- You'll also need an API key and secret from Amadeus. Get them [here](https://developers.amadeus.com/register).

## Installation

1. Clone [this repo](https://github.com/jgrams/amadeus_java_flight_api/), or if you only want the backend clone the [backend only branch](https://github.com/jgrams/amadeus_java_flight_api/tree/backend-only).
1. Install the Maven depenencies by running `mvn clean install` in the base directory (or use your IDE!).
1. Install the NPM dependencies by running `npm install` in the `src/main/ui/` directory.
1. Add your API key and secret to the `src/main/java/com/app/flight/AmadeusConnect.java` file.

## Running the App

1. Run the back end Java app on port 8080 from your IDE. You can also run the app directly by using `./mvnw spring-boot:run` in the home directory.
1. Run the front end application on port 3000 by running `npm start` in the `src/main/ui/` directory.
