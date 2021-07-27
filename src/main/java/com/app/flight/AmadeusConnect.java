package com.app.flight;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.amadeus.resources.Resource;
import com.amadeus.referenceData.Locations;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightPrice;
import com.amadeus.resources.FlightOrder;

enum AmadeusConnect {
    INSTANCE;
    private Amadeus amadeus;
    private AmadeusConnect() {
        this.amadeus = Amadeus
            .builder("a3o4AnIgFZSNBYwo80SJWYHDGkcAlfZg", "S4BGFFVkW87lst6F")
            .build();
    }

    public String toJson(Resource resource) {
        return resource.getResponse().getBody();
    }

    public Location[] location(String keyword) throws ResponseException {
        return amadeus.referenceData.locations.get(Params
            .with("keyword", keyword)
            .and("subType", Locations.AIRPORT));
    }

    public FlightOfferSearch[] flights(String origin, String destination, String departDate, String returnDate, String adults) throws ResponseException {
        return amadeus.shopping.flightOffersSearch.get(
                  Params.with("originLocationCode", origin)
                          .and("destinationLocationCode", destination)
                          .and("departureDate", departDate)
                          .and("returnDate", returnDate)
                          .and("adults", adults)
                          .and("max", 3));
    }

    public FlightPrice confirm(FlightOfferSearch offer) throws ResponseException {
        return amadeus.shopping.flightOffersSearch.pricing.post(toJson(offer));
    }

    public FlightOrder order(FlightPrice price) throws ResponseException {
        return amadeus.booking.flightOrders.post(toJson(price));
    }
}