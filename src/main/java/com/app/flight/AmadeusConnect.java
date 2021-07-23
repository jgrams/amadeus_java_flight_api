package com.app.flight;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.amadeus.referenceData.Locations;
import com.amadeus.exceptions.ResponseException;


enum AmadeusConnect {
    INSTANCE;
    private Amadeus amadeus;

    private AmadeusConnect() {
        this.amadeus = Amadeus
            .builder("a3o4AnIgFZSNBYwo80SJWYHDGkcAlfZg", "S4BGFFVkW87lst6F")
            .build();
    }

    public String location(String keyword) throws ResponseException {
        Location[] locations = amadeus.referenceData.locations.get(Params
            .with("keyword", keyword)
            .and("subType", Locations.AIRPORT));
        return locations[0].getResponse().getBody();
    }

    public String flights(String origin, String destination) throws ResponseException {
        FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                  Params.with("originLocationCode", origin)
                          .and("destinationLocationCode", destination)
                          .and("departureDate", "2021-11-01")
                          .and("returnDate", "2021-11-08")
                          .and("adults", 2)
                          .and("max", 3));
        return flightOffersSearches[0].getResponse().getBody();
    }
}