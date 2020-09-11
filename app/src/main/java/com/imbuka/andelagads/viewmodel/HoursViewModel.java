package com.imbuka.andelagads.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.imbuka.andelagads.service.model.Hours;
import com.imbuka.andelagads.service.repository.GadsRepository;

public class HoursViewModel extends AndroidViewModel {

    private final LiveData<List<Hours>> hoursListObservable;
    public HoursViewModel(@NonNull Application application) {
        super(application);

        hoursListObservable = GadsRepository.getInstance().getHoursList();
    }

    public LiveData<List<Hours>> getHoursListObservable(){return hoursListObservable;}
}
