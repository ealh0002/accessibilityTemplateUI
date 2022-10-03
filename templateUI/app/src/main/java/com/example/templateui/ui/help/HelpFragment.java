package com.example.templateui.ui.help;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.templateui.R;
import com.example.templateui.databinding.FragmentHelpBinding;


public class HelpFragment extends Fragment {

    private FragmentHelpBinding binding;
    private TextView uploadVideo;
    private TextView shortcutHistory;
    private TextView exploreMore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HelpViewModel exploreViewModel =
                new ViewModelProvider(this).get(HelpViewModel.class);


        binding = FragmentHelpBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHelp;
        exploreViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        // how to upload video button
        uploadVideo = (TextView) root.findViewById(R.id.video_upload);
        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callVideoUpload();
            }
        });

        // how to upload video button
        shortcutHistory = (TextView) root.findViewById(R.id.shortcut_history);
        shortcutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callShortcutHistory();
            }
        });

        // how to upload video button
        exploreMore = (TextView) root.findViewById(R.id.explore_videos);
        exploreMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { callExploreVideos(); }
        });

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void callVideoUpload(){
        Intent intent = new Intent(getActivity(), VideoUploadManual.class);
        startActivity(intent);
    }

    public void callShortcutHistory(){
        Intent intent = new Intent(getActivity(), ShortcutHistoryManual.class);
        startActivity(intent);
    }

    public void callExploreVideos(){
        Intent intent = new Intent(getActivity(), ExploreVideosManual.class);
        startActivity(intent);
    }

}
