package com.example.osman.restaurantmsandroid.factories;

import com.example.osman.restaurantmsandroid.domain.AddressType;

/**
 * Created by Osman on 2016-04-19.
 */
public class AddressTypeFactory {
    public static AddressType getAddressType(String name){
        AddressType addressType = new AddressType.Builder()
                .name(name)
                .build();
        return addressType;
    }
}
