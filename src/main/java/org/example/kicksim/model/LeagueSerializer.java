package org.example.kicksim.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class LeagueSerializer extends JsonSerializer<League> {
    @Override
    public void serialize(League league, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if(league != null){
            gen.writeStartObject();
            gen.writeNumberField("id", league.getId());
            gen.writeStringField("name", league.getName());
            gen.writeEndObject();
        }
        else{
            gen.writeNull();
        }

    }
}
