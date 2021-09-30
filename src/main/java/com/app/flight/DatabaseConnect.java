package com.app.flight;
import com.amadeus.resources.Traveler;
import com.amadeus.resources.Traveler.Document;
import com.amadeus.resources.Traveler.Name;
import com.amadeus.resources.Traveler.Phone;
import com.google.gson.JsonObject;
import com.amadeus.resources.Traveler.Contact;

public class DatabaseConnect {
      public static Traveler traveler(JsonObject travelerInfo) {
        String fname = travelerInfo.get("fname").getAsString();
        String lname = travelerInfo.get("lname").getAsString();
        String dateOfBirth = travelerInfo.get("dob").getAsString();
        Traveler traveler = new Traveler();

        Phone phone = traveler.new Phone();
        phone.setCountryCallingCode("1");
        phone.setNumber("1231231234");
        phone.setDeviceType("MOBILE");

        Contact contact = traveler.new Contact();
        Phone[] phones = {phone};
        contact.setPhones(phones);
        traveler.setContact(contact);

        Name name = traveler.new Name(fname, lname);
        traveler.setName(name);

        traveler.setDateOfBirth(dateOfBirth);
        traveler.setId("1");
        Document document = traveler.new Document();
        document.setDocumentType("PASSPORT");
        document.setNumber("00000000");
        document.setExpiryDate("2025-04-14");
        document.setNationality("ES");
        document.setHolder(true);
        document.setIssuanceCountry("ES");
        Document[] documents = {document};
        traveler.setDocuments(documents);
        return traveler;
    }
}
