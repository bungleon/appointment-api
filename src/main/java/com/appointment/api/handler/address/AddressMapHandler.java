package com.appointment.api.handler.address;

import com.appointment.api.domain.address.*;
import com.appointment.api.handler.Handler;
import com.appointment.api.service.address.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
    private final TownService townService;
    private final DistrictService districtService;
    private final AddressService addressService;

    private static final String COUNTRIES = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/country.txt";
    private static final String TR_PROVINCE = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/province.txt";
    private static final String TR_TOWN = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/town.txt";
    private static final String TR_DISTRICT = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/district.txt";
    private static final String TR_ADDRESS = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/address.txt";

    public AddressMapHandler(CountryService countryService, ProvinceService provinceService, TownService townService,
                             DistrictService districtService, AddressService addressService) {
        this.countryService = countryService;
        this.provinceService = provinceService;
        this.townService = townService;
        this.districtService = districtService;
        this.addressService = addressService;
    }

    @Override
    public String execute(String request) throws IOException {
        //List<String[]> countryListString = getList(COUNTRIES);
        List<String[]> trProvinceListString = getList(TR_PROVINCE);
        List<String[]> trTownListString = getList(TR_TOWN);
        List<String[]> trDistrictListString = getList(TR_DISTRICT);
        List<String[]> trAddressListString = getList(TR_ADDRESS);

        // List<Country> countryList = setCountry(countryListString);
        List<Province> trProvinceList = setTrProvince(trProvinceListString);


        // TODO yarın test et
        setOthers(trProvinceList, trTownListString, trDistrictListString, trAddressListString);

        return request;
    }

   /* private List<Country> setCountry(List<String[]> countryListString) {
        if (!countryService.control()) {
            return null;
        }
        List<Country> countryList = new LinkedList<>();
        for (String[] s : countryListString) {
            Country country = new Country();
            country.setBinaryCode(s[0]);
            country.setTripleCode(s[1]);
            country.setPhoneCode(s[3]);
            country.setName(s[2]);
            countryList.add(countryService.add(country));

        }
        return countryList;
    }*/

    private List<Province> setTrProvince(List<String[]> trProvinceListString) {
        Country country = countryService.getCountryByBinaryCode("TR");
        if (!CollectionUtils.isEmpty(provinceService.getByCountry(country))) {
            return provinceService.getByCountry(country);
        }
        List<Province> provinceList = new LinkedList<>();
        for (String[] s : trProvinceListString) {
            Province province = new Province();
            province.setCode(s[1]);
            province.setCountry(country);
            province.setName(s[0]);
            province.setPhoneCode(s[2]);
            provinceList.add(provinceService.add(province));
        }
        return provinceList;
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

    private void setOthers(List<Province> provinceList, List<String[]> towns, List<String[]> districts, List<String[]> addresses) {
        for (Province p : provinceList) {
            // Get Towns
            List<String[]> uniqueTowns = getAdresses(towns, p.getCode());
            for (String[] t : uniqueTowns) {
                Town town = new Town();
                town.setName(t[2]);
                town.setProvince(p);
                Town savedTown = townService.add(town);
                // Get Districts
                List<String[]> uniqueDistricts = getAdresses(districts, t[0]);
                for (String[] d : uniqueDistricts) {
                    District district = new District();
                    district.setName(d[2]);
                    district.setTown(savedTown);
                    District savedDistrict = districtService.add(district);
                    // Get Address
                    List<String[]> uniqueAddress = getAdresses(addresses, d[0]);
                    for (String[] a : uniqueAddress) {
                        Address address = new Address();
                        address.setDistrict(savedDistrict);
                        address.setNeighborhood(a[2]);
                        address.setZipCode(a[3]);
                        addressService.add(address);
                    }
                }
            }
        }
    }

    private List<String[]> getAdresses(List<String[]> town, String key) {
        List<String[]> ret = new LinkedList<>();
        for (String[] t : town) {
            if (t[1].equals(key)) {
                ret.add(t);
            }
        }
        return ret;
    }

    private void deleteRecords(List<Province> provinceList, List<String[]> towns, List<String[]> districts, List<String[]> addresses){
    }
}
