package com.nv.superheroapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Navneet Krishna on 16/12/18.
 */
public interface HeroInterface {
    @GET("a")
    Call<HeroResponse> getJson();
    @GET("{name}")
    Call<HeroResponse> getName(@Path("name") String name);
    @GET("{id}/powerstats")
    Call<Powerstats> getPowerstats(@Path("id") String id);
}
