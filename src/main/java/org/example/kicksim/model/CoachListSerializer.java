package org.example.kicksim.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public class CoachListSerializer extends JsonSerializer<List<Coach>> {

    @Override
    public void serialize(List<Coach> coaches, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray(); // Start JSON array
        for (Coach coach : coaches) {
            gen.writeStartObject(); // Start JSON object for each coach
            gen.writeStringField("firstName", coach.getFirstName());
            gen.writeStringField("lastName", coach.getLastName());
            gen.writeEndObject(); // End JSON object for each coach
        }
        gen.writeEndArray(); // End JSON array
    }
}
