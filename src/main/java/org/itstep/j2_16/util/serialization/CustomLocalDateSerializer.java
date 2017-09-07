package org.itstep.j2_16.util.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class CustomLocalDateSerializer extends JsonSerializer<LocalDate> {
    
    @Override
    public void serialize(LocalDate value, JsonGenerator jsonGenerator, SerializerProvider serializers)
            throws IOException {
        jsonGenerator.writeString(value.format(ISO_LOCAL_DATE));
    }
}
