package org.example.kicksim.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public class TeamListSerializer extends JsonSerializer<List<Team>> {

    @Override
    public void serialize(List<Team> teams, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray(); // Start the JSON array
        for (Team team : teams) {
            gen.writeStartObject(); // Start a JSON object for each team
            gen.writeNumberField("id", team.getId());
            gen.writeStringField("teamName", team.getTeamName());
            gen.writeStringField("teamNationality", team.getTeamNationality().toString());
            gen.writeNumberField("yearFounded", team.getYearFounded());
            gen.writeEndObject(); // End the JSON object
        }
        gen.writeEndArray(); // End the JSON array
    }
}
