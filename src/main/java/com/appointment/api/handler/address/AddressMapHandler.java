package com.appointment.api.handler.address;

import com.appointment.api.domain.address.Country;
import com.appointment.api.handler.Handler;
import com.appointment.api.service.address.CountryService;
import com.appointment.api.service.address.ProvinceService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class AddressMapHandler implements Handler<String, String> {
    private final CountryService countryService;
    private final ProvinceService provinceService;
    private static final String COUNTRIES = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/country.txt";
    private static final String TR_PROVINCE = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/province.txt";
    private static final String TR_TOWN = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/town.txt";
    private static final String TR_DISTRICT = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/district.txt";
    private static final String TR_ADDRESS = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/address.txt";

    public AddressMapHandler(CountryService countryService, ProvinceService provinceService) {
        this.countryService = countryService;
        this.provinceService = provinceService;
    }

    @Override
    public String execute(String request) throws IOException {
        List<String[]> countryListString = getList(COUNTRIES);
        List<String[]> trProvinceListString = getList(TR_PROVINCE);
        List<String[]> trTownListString = getList(TR_TOWN);
        List<String[]> trDistrictListString = getList(TR_DISTRICT);
        List<String[]> trAddressListString = getList(TR_ADDRESS);

        List<Country> countryList = setCountry(countryListString);
        return request;
    }

    private List<Country> setCountry(List<String[]> countryListString) {
        if(!countryService.control()){
            return null;
        }
        List<Country> countryList = new LinkedList<>();
        for (String[] s : countryListString) {
            Country country = new Country();
            country.setBinaryCode(s[0]);
            country.setTripleCode(s[1]);
            country.setPhoneCode(s[3]);
            country.setName(s[2]);
            countryList.add(country);
        }
        return countryList;
    }

    private List<String[]> getList(String path) {
        List<String[]> list = new LinkedList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader br = null;
        String line;
        try {
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                list.add(line.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
