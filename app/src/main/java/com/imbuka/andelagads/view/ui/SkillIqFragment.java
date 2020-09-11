package com.imbuka.andelagads.view.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import kapadokia.nyandoro.andelagads.databinding.FragmentSkillIqBinding;
import kapadokia.nyandoro.andelagads.service.model.SkillIqs;
import kapadokia.nyandoro.andelagads.view.adapters.SkillIqAdapter;
import kapadokia.nyandoro.andelagads.viewmodel.SkillIqViewModel;


public class SkillIqFragment extends Fragment {

    private static final String TAG = "SkillIqFragment";

    private FragmentSkillIqBinding binding;
    private SkillIqAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSkillIqBinding.inflate(inflater,container,false);
        adapter = new SkillIqAdapter();
        binding.skillRecycler.setAdapter(adapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final SkillIqViewModel skillIqViewModel = ViewModelProviders.of(this).get(SkillIqViewModel.class);

        observeViewModel(skillIqViewModel);

    }

    private void observeViewModel(SkillIqViewModel skillIqViewModel) {
        // Update the list when the data changes
        skillIqViewModel.getSkillIqListObservable().observe(this, new Observer<List<SkillIqs>>() {
            @Override
            public void onChanged(List<SkillIqs> skillIqs) {
                binding.setIsLoading(false);
                adapter.setSkillsList(skillIqs);
            }
        });
    }
}