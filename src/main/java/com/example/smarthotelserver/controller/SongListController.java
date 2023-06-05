package com.example.smarthotelserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class SongListController {
    @GetMapping("/song-list")
    public List<Song> getSongList(){
        List<Song> songList = new ArrayList<>();


        Song song1 = new Song(1, "Tetris theme");
        Song song2 = new Song(2, "Super Mario Bros' overworld theme");
        Song song3 = new Song(3, "Cannon");
        Song song4 = new Song(4, "Take on me");
        Song song5 = new Song(5, "The Lion Sleeps Tonight");
        Song song6 = new Song(6, "Star Wars theme");
        Song song7 = new Song(7, "Harry Potter");
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);
        songList.add(song5);
        songList.add(song6);
        songList.add(song7);
        return songList;
    }

    // 곡 정보를 담는 클래스
    public static class Song {
        private int songNumber;
        private String songString;

        public Song(int songNumber, String songString) {
            this.songNumber = songNumber;
            this.songString = songString;
        }

        public int getSongNumber() {
            return songNumber;
        }

        public String getSongString() {
            return songString;
        }
    }
}
