package org.example.kicksim.model;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public class PlayerListSerializer extends JsonSerializer<List<Player>> {


    @Override
    public void serialize(List<Player> players, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (Player player : players){
            gen.writeStartObject();
            gen.writeStringField("firstName", player.getFirstName());
            gen.writeStringField("lastName", player.getLastName());
            gen.writeEndObject();
        }

        gen.writeEndArray();
    }
}
