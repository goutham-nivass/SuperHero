package com.nv.superheroapi.Test;

import com.nv.superheroapi.HeroInterface;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "https://www.superheroapi.com/api.php/1931148220375954/search/";

    public static HeroInterface getUserService(){
        return RetrofitClient.getClient(API_URL).create(HeroInterface.class);
    }

}
