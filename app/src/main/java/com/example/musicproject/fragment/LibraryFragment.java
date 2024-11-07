package com.example.musicproject.fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.musicproject.Animation;
import com.example.musicproject.DatabaseHelper;
import com.example.musicproject.MusicActivity;
import com.example.musicproject.R;
import com.example.musicproject.Song;
import com.example.musicproject.SongAdaper;
import com.example.musicproject.SubActivity;

import java.util.ArrayList;


public class LibraryFragment extends Fragment {
    DatabaseHelper helper;

    ArrayList<Song> songs;
    ListView lvLibrary;
    SongAdaper adaper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new DatabaseHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        lvLibrary = view.findViewById(R.id.lvLibrary);
            this.songs = helper.getAllFauSongs();
            if(songs != null){
                adaper= new SongAdaper(getActivity(),R.layout.song_item,songs,false);
                lvLibrary.setAdapter(adaper);
            }

        lvLibrary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animation.setAnimation(view);
                Song song = songs.get(i);
                Intent intent = new Intent(getActivity(), SubActivity.class);
                intent.putExtra("song",song);
                intent.putExtra("songs",songs);
                startActivity(intent);
            }
        });
        return view;
    }
}