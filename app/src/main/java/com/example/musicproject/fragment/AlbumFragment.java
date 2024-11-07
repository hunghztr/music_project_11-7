package com.example.musicproject.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.musicproject.Album;
import com.example.musicproject.AlbumAdapter;
import com.example.musicproject.DatabaseHelper;
import com.example.musicproject.R;
import com.example.musicproject.Song;
import com.example.musicproject.SongAdaper;
import com.example.musicproject.SubActivity;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {
    ListView lvAlbum;
    AlbumAdapter adaper;
    ArrayList<Song> songs;
    ArrayList<Album> albums;
    DatabaseHelper helper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new DatabaseHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album, container, false);
        albums = helper.getAllAlbums();
        adaper = new AlbumAdapter(getActivity(),R.layout.song_item,albums);
        lvAlbum = view.findViewById(R.id.lvAlbum);
        lvAlbum.setAdapter(adaper);
        lvAlbum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Album album = albums.get(i);
                ArrayList<Song> songs1 = helper.getAllSongsByAlbum(album.getId());
                Song song = songs1.get(0);
                Intent intent = new Intent(getActivity(), SubActivity.class);
                intent.putExtra("songs",songs1);
                intent.putExtra("song",song);
                startActivity(intent);
            }
        });
        return view;
    }
}