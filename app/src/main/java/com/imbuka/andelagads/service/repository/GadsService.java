package com.imbuka.andelagads.service.repository;

import java.util.List;

import kapadokia.nyandoro.andelagads.service.model.Hours;
import kapadokia.nyandoro.andelagads.service.model.SkillIqs;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GadsService {

    // defining the baseUrl
   String BASE_URL ="https://gadsapi.herokuapp.com";
   // submission Url
   String SUBMIT_URL="https://docs.google.com/forms/d/e/";

   //get all hours
    @GET("/api/hours")
    Call<List<Hours>> getAllHours();

    // get skill Iqs
    @GET("/api/skilliq")
    Call<List<SkillIqs>> getAllSkillIqs();

 // to handle submit
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<Void> submitProject(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String first_name,
            @Field("entry.2006916086") String last_name,
            @Field("entry.284483984") String project_link
    );

}
