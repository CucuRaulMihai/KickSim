package org.example.kicksim.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class TeamSerializer extends JsonSerializer<Team> {


    @Override
    public void serialize(Team team, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (team != null) {
            gen.writeStartObject();
            gen.writeNumberField("id", team.getId());
            gen.writeStringField("teamName", team.getTeamName());
            gen.writeStringField("teamNationality", team.getTeamNationality().toString());
            gen.writeNumberField("yearFounded", team.getYearFounded());
            gen.writeEndObject();
        } else {
            gen.writeNull();
        }
    }
}
