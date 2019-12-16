package hu.absence.model.service;

import hu.absence.model.domain.Absence;

import java.util.List;

public class DataApi {

    private final FileReader fileReader;
    private final DataParser dataParser;

    public DataApi(FileReader fileReader, DataParser dataParser) {
        this.fileReader = fileReader;
        this.dataParser = dataParser;
    }

    public List<Absence> getData(String input) {
        return dataParser.parse(fileReader.read(input));
    }
}
