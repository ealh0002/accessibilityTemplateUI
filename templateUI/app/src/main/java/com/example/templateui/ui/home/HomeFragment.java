package com.example.templateui.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.templateui.ProgressCheck;
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

    // Upload button
    private Button uploadButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //history list
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

        // upload button
        uploadButton = (Button) root.findViewById(R.id.upload_button);
        uploadButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                showProgress();
                                            }
                                        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showProgress(){
        Intent intent = new Intent(getActivity(), ProgressCheck.class);
        startActivity(intent);
    }
}