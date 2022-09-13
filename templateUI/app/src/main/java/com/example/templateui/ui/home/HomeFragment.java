package com.example.templateui.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.templateui.R;
import com.example.templateui.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    // for the lists of actions
    ListView listView;
    List list = new ArrayList();
    ArrayAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = (ListView) root.findViewById(R.id.list_history);
        list.add("action 1");
        list.add("action 2");
        list.add("action 3");
        list.add("action 3");
        list.add("action 3");
        list.add("action 3");
        list.add("action 3");
        list.add("action 3");
        list.add("action last");



        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}