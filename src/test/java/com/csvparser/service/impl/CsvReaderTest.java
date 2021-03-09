package com.csvparser.service.impl;

import com.csvparser.model.Machine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class CsvReaderTest {
    private static CsvReader csvReader;

    @BeforeAll
    static void beforeAll() {
        csvReader = new CsvReader();
    }

    @Test
    void readCsvOneLine_Ok() throws FileNotFoundException {
        List<Machine> expectedOneLine = new ArrayList<>();
        Machine machine = new Machine("Eulalia Kshlerin",
                false,
                "germany",
                "usd",
                "Year of manufacture: 2017, Type: Attachments, Actuation: Hydraulic drive",
                "straw blowers/bale splitters",
                "[\"https://landwirshaft-top.de/media/9853/3689853/18765111/3689853-18765111" +
                        ".jpg?width=225&height=175&quality=70&crop\"]",
                3689853,
                4950,
                "landwirshaft-top.de",
                "https://www.landwirshaft-top.de/en/3689853");
        expectedOneLine.add(machine);

        File file = new File("src/test/resources/Test.csv");
        FileInputStream inputStream = new FileInputStream(file);
        Assertions.assertEquals(expectedOneLine, csvReader.csvMachines(inputStream));
    }

    @Test
    void readCsvAllFile_Ok() throws FileNotFoundException {
        List<Machine> expected = new ArrayList<>();
        Machine machineEulalia = new Machine("Eulalia Kshlerin",
                false,
                "germany",
                "usd",
                "Year of manufacture: 2017, Type: Attachments, Actuation: Hydraulic drive",
                "straw blowers/bale splitters",
                "[\"https://landwirshaft-top.de/media/9853/3689853/18765111/3689853-18765111" +
                        ".jpg?width=225&height=175&quality=70&crop\"]",
                3689853,
                4950,
                "landwirshaft-top.de",
                "https://www.landwirshaft-top.de/en/3689853");

        Machine machineDarby = new Machine("Darby Raynor",
                true,
                "poland",
                "aud",
                "Year of manufacture: 2020, Round bales, Silage bales, Throwing range: 8.00 m, " +
                        "Type: Front-end loader extension, Actuation: Hydraulic drive",
                "straw blowers/bale splitters",
                "[\"https://landwirshaft-top.de/media/6163/5566163/32637429/5566163-32637429" +
                        ".jpg?width=225&height=175&quality=70&crop\"]",
                5566163,
                12900,
                "landwirshaft-top.de",
                "https://www.landwirshaft-top.de/en/5566163");

        Machine machineFiona = new Machine("Fiona Walter",
                true,
                "sweden",
                "aud",
                "Year of manufacture: 2016",
                "straw blowers/bale splitters",
                "[\"https://powercombines.co.uk/media/5730/5565730/32634345/5565730-32634345" +
                        ".jpg?width=225&height=175&quality=70&crop\"]",
                5565730,
                125000,
                "powercombines.co.uk",
                "https://www.powercombines.co.uk/en/5565730");

        Machine machineTed = new Machine("Ted Kreiger",
                false,
                "austria",
                "usd",
                "",
                "straw blowers/bale splitters",
                "[\"https://der-bauer-freund.de/media/1566/5561566/32598326/5561566-32598326" +
                        ".jpg?width=225&height=175&quality=70&crop\"]",
                5561566,
                2433.63,
                "der-bauer-freund.de",
                "https://www.der-bauer-freund.de/en/5561566");

        Machine machineLizzie = new Machine("Lizzie Wunsch",
                true,
                "luxembourg",
                "usd",
                "Year of manufacture: 2005, Lights, hydraulic Tailgate, Rotating discharge chute, " +
                        "Type: trailed, Actuation: PTO drive system",
                "straw blowers/bale splitters",
                "[\"https://landwirshaft-top.de/media/8236/5558236/32572257/5558236-32572257" +
                        ".jpg?width=225&height=175&quality=70&crop\"]",
                5558236,
                6900,
                "landwirshaft-top.de",
                "https://www.landwirshaft-top.de/en/5558236");

        Machine machineMarcella = new Machine("Marcella Purdy",
                false,
                "poland",
                "gbp",
                "Year of manufacture: 2020, Lights, hydraulic Tailgate, Rotating discharge chute," +
                        " Square bales, Silage bales, Throwing range: 18.00 m, Actuation: PTO drive system",
                "straw blowers/bale splitters",
                "[\"https://powercombines.co.uk/media/9759/5549759/32511390/5549759-32511390." +
                        "jpg?width=225&height=175&quality=70&crop\"]",
                5549759,
                59000,
                "powercombines.co.uk",
                "https://www.powercombines.co.uk/en/5549759");

        Machine machineFrank = new Machine("Frank Tillman",
                false,
                "uk",
                "gbp",
                "Year of manufacture: 2018",
                "straw blowers/bale splitters",
                "[\"https://der-bauer-freund.de/media/3486/5523486/32344877/5523486-32344877" +
                        ".jpg?width=225&height=175&quality=70&crop\"]",
                5523486,
                11250,
                "der-bauer-freund.de",
                "https://www.der-bauer-freund.de/en/5523486");

        expected.add(machineEulalia);
        expected.add(machineDarby);
        expected.add(machineFiona);
        expected.add(machineTed);
        expected.add(machineLizzie);
        expected.add(machineMarcella);
        expected.add(machineFrank);

        File file = new File("src/test/resources/Machines.csv");
        FileInputStream inputStream = new FileInputStream(file);
        Assertions.assertEquals(expected, csvReader.csvMachines(inputStream));
    }

    @Test
    void readCsv_NotOk() throws FileNotFoundException {
        List<Machine> expected = new ArrayList<>();

        File file = new File("src/test/resources/Machines.csv");
        FileInputStream inputStream = new FileInputStream(file);
        Assertions.assertNotEquals(expected, csvReader.csvMachines(inputStream));
    }
}