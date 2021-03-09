package com.csvparser.service.impl;

import com.csvparser.exception.DataProcessingException;
import com.csvparser.model.Machine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvReader {
    public List<Machine> csvMachines(InputStream stream) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(stream,
                "UTF-8"));
                 CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase()
                             .withTrim());) {
            List<Machine> machines = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Machine machine = new Machine(
                        csvRecord.get("owner"),
                        Boolean.parseBoolean(csvRecord.get("available")),
                        csvRecord.get("country"),
                        csvRecord.get("currency"),
                        csvRecord.get("machineInfo"),
                        csvRecord.get("machineType"),
                        csvRecord.get("photos"),
                        Integer.parseInt(csvRecord.get("sourceId")),
                        Double.parseDouble(csvRecord.get("price")),
                        csvRecord.get("source"),
                        csvRecord.get("url")
                );
                machines.add(machine);
            }
            return machines;
        } catch (IOException e) {
            throw new DataProcessingException("Can't parse CSV file: " + e);
        }
    }
}
