package com.appointment.api.handler.address;

import com.appointment.api.domain.country.Country;
import com.appointment.api.domain.province.Province;
import com.appointment.api.domain.town.Town;
import com.appointment.api.handler.Handler;
import com.appointment.api.service.address.AddressService;
import com.appointment.api.service.country.CountryService;
import com.appointment.api.service.district.DistrictService;
import com.appointment.api.service.province.ProvinceService;
import com.appointment.api.service.town.TownService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

@Component
public class AddressMapHandler implements Handler<String, String> {
    private final CountryService countryService;
    private final ProvinceService provinceService;
    private final TownService townService;
    private final DistrictService districtService;
    private final AddressService addressService;

    //private static final String COUNTRIES = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/country.txt";
    private static final String TR_PROVINCE = "/Users/erman/Desktop/province.txt";
    private static final String TR_TOWN = "/Users/erman/Desktop/district.txt";
    //private static final String TR_DISTRICT = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/district.txt";
    //private static final String TR_ADDRESS = "/Users/erman/Desktop/Countries_MySQL_SchemaAndData_20180112/address.txt";

    public AddressMapHandler(CountryService countryService, ProvinceService provinceService, TownService townService,
                             DistrictService districtService, AddressService addressService) {
        this.countryService = countryService;
        this.provinceService = provinceService;
        this.townService = townService;
        this.districtService = districtService;
        this.addressService = addressService;
    }

    @Override
    public String execute(String request) {
        //List<String[]> countryListString = getList(COUNTRIES);
        List<String[]> trProvinceListString = getList(TR_PROVINCE);
        List<String[]> trTownListString = getList(TR_TOWN);

        // List<Country> countryList = setCountry(countryListString);
        List<Province> trProvinceList = setAfProvince(trProvinceListString);


        // TODO yarın test et
        //setOthers(trProvinceList, trTownListString);
        /*deleteTownRecords(trTownListString);
        deleteDistrictRecords(trDistrictListString);
        deleteAdressesRecords(trAddressListString);*/
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

    private List<Province> setAfProvince(List<String[]> trProvinceListString) {
        Country country = countryService.getCountryByBinaryCode("AF");
        if (!CollectionUtils.isEmpty(provinceService.getByCountry(country))) {
            return provinceService.getByCountry(country);
        }
        List<Province> provinceList = new LinkedList<>();
        for (String[] s : trProvinceListString) {
            Province province = new Province();
            province.setCode(s[2]);
            province.setCountry(country);
            province.setName(s[3]);
            //province.setPhoneCode(s[2]);
            province.setOriginalName(s[4]);
            province.setLatitude(s[0]);
            province.setLongitude(s[1]);
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

    private void setOthers(List<Province> provinceList, List<String[]> towns) {
        for (Province p : provinceList) {
            // Get Towns
            List<String[]> uniqueTowns = getAddresses(towns, p.getCode());
            for (String[] t : uniqueTowns) {
                Town town = new Town();
                town.setName(t[3]);
                town.setOriginalName(t[5]);
                town.setCode(t[7]);
                town.setProvince(p);
                town.setLatitude(t[1]);
                town.setLongitude(t[0]);
                townService.add(town);
            }
        }
    }

    private List<String[]> getAddresses(List<String[]> town, String key) {
        List<String[]> ret = new LinkedList<>();
        for (String[] t : town) {
            if (t[8].equals(key)) {
                ret.add(t);
            }
        }
        return ret;
    }

    private void deleteAdressesRecords(List<String[]> addresses) {
        List<String[]> addresses2 = new LinkedList<>();
        addresses2.addAll(addresses);
        for (String[] s : addresses) {
            if (addressService.getByNameAndZipCode(s[2], s[3]) != null) {
                addresses2.remove(s);
            }
        }

        System.out.println(addresses2.size());
    }

    private void deleteDistrictRecords(List<String[]> districts) {
        List<String[]> districts2 = new LinkedList<>();
        districts2.addAll(districts);
        for (String[] s : districts) {
            if (addressService.getByNameAndZipCode(s[2], s[3]) != null) {
                districts2.remove(s);
            }
        }

        System.out.println(districts2.size());
    }

    private void deleteTownRecords(List<String[]> towns) {
        List<String[]> towns2 = new LinkedList<>();
        towns2.addAll(towns);
        for (String[] s : towns) {
            if (townService.getByNameAndProvinceCode(s[2], s[1]) != null) {
                towns2.remove(s);
            }
        }

        System.out.println(towns2.size());
    }
}
