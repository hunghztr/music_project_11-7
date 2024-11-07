package com.example.musicproject.Data;

import com.example.musicproject.Album;
import com.example.musicproject.DatabaseHelper;
import com.example.musicproject.R;
import com.example.musicproject.Song;

import java.util.ArrayList;

public class DataForm {
    public static ArrayList<Song> setSongData(){
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song(R.drawable.attention,"Attention","Charlie Puth",R.raw.attention));
        songs.add(new Song(R.drawable.girls_like_you,"Girls Like You","Maroon 5",R.raw.girls_like_you));
        songs.add(new Song(R.drawable.memories,"Memories","Maroon 5",R.raw.memories));
        songs.add(new Song(R.drawable.one_call_away,"One Call Away","Charlie Puth",R.raw.one_call_away));
        songs.add(new Song(R.drawable.perfect,"Perfect","Ed Sheraan",R.raw.perfect));
        songs.add(new Song(R.drawable.see_you_again,"See You Again","Charlie Puth",R.raw.see_you_again));
        songs.add(new Song(R.drawable.shape_of_you,"Shape Of You","Ed Sheraan",R.raw.shape_of_you));
        songs.add(new Song(R.drawable.sugar,"Sugar","Maroon 5",R.raw.sugar));
        songs.add(new Song(R.drawable.that_girl,"That Girl","Olly Murs",R.raw.that_girl));
        songs.add(new Song(R.drawable.we_dont_talk_anymore,"We Dont Talk Anymore","Charlie Puth",R.raw.we_dont_talk_anymore));
        return songs;
    }
    public static ArrayList<Album> setAlbumData(){
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album(R.drawable.charlie_puth,"Forever All","Charlie Puth"));
        albums.add(new Album(R.drawable.ed_sheraan,"Love For All","Ed Sheraan"));
        albums.add(new Album(R.drawable.maroon_5,"At Together","Maroon 5"));

        return albums;
    }
    public static void setSongInAlbum(ArrayList<Song> songs , ArrayList<Album> albums, DatabaseHelper helper){
        for(Song i : songs){
            if(i.getSingerName().compareTo("Charlie Puth") == 0){
                helper.addSongToAlbum(i,albums.get(0));
            }else if(i.getSingerName().compareTo("Maroon 5") == 0){
                helper.addSongToAlbum(i,albums.get(2));
            }else if(i.getSingerName().compareTo("Ed Sheraan") == 0){
                helper.addSongToAlbum(i,albums.get(1));
            }
        }
    }
}
