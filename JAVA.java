/*------------------------------------------------------
My name:Alex Aiello
My subject code: CSIT111
-------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Scanner;

public class MyPlayList {
    ArrayList<Song> playList = new ArrayList<Song>();
    public static Scanner scanner = new Scanner(System.in);
    public static String[] menus = { 
                            "Add a new song", 
                            "List All song", 
                            "Delete an existing song", 
                            "Search for a song",
                            "Display total playTime", 
                            "exit" 
                        };

    public static void main(String[] args) {
        displayMenuSystem();
    }

    public static void displayMenuSystem() {
        System.out.println("Welcome to my PlayList!");
        MyPlayList myPlayList = new MyPlayList();
        while (true) {

            for (int i = 1; i <= menus.length; i++) {
                System.out.println(i + " - " + menus[i - 1]);
            }
            System.out.println("\nPlease enter your choice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    myPlayList.addSong();
                    break;
                }
                case 2: {
                    myPlayList.displayList();
                    break;
                }
                case 3: {
                    myPlayList.deleteSong();
                    break;
                }
                case 4: {
                    myPlayList.searchSong();
                    break;
                }
                case 5: {
                    myPlayList.displayTotalPlayTime();
                    break;
                }
                case 6: {
                    System.out.println("\nThank you\n");
                    return;
                }
                default: {
                    System.out.println("\nEnter a valid choice\n");
                    continue;
                }
            }

        }

    }

    // adding song to the play-list
    public void addSong() {

        // taking user input

        System.out.println("Title of the song");
        String song = scanner.nextLine();
        System.out.println("Name of the artist");
        String artist = scanner.nextLine();
        System.out.println("type of the song");
        String type = scanner.nextLine();
        System.out.println("Duration of the song");
        int duration = Integer.parseInt(scanner.nextLine());

        // create song object and assign value to it
        Song songObject = new Song(song, artist, type, duration);
        playList.add(songObject);

        System.out.println(song + " Added success fully in playList\n");

    }

    // delete song method
    public void deleteSong() {
        int size = playList.size();
        System.out.println("There are " + playList.size() + " songs in your library : ");

        // if play list is not empty
        if (size > 0) {
            // print all the song
            for (int i = 1; i <= size; i++) {
                System.out.println(i + ": " + playList.get(i - 1).getTitle());
            }
            System.out.println("Which song you want to delete (please input the index)?:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            // validating index value
            while (choice > size && choice < 1) {
                System.out.println("enter valid index value : ");
                choice = scanner.nextInt();
                scanner.nextLine();
            }

            // removing song
            Song removed = playList.remove(choice - 1);

            System.out.println(removed.getTitle() + " is removed from your library\n");
        }
        // if play-list is empty
        else {
            System.out.println("Please add song first\n");
        }
    }

    // search song
    public void searchSong() {
        int size = playList.size();
        // if play list is not empty
        if (size > 0) {
            // taking user input
            System.out.println("Please input the title of the song :");
            String title = scanner.nextLine();
            ArrayList<Song> searchedItem = new ArrayList<Song>();

            // search for song
            for (Song s : playList) {
                if (s.getTitle().contains(title.trim())) {
                    searchedItem.add(s);
                }
            }

            // if searched list size is not zero
            if (searchedItem.size() > 0) {
                System.out.println("The Song is found in your library, here are the details \n");
                for (int i = 1; i <= searchedItem.size(); i++) {
                    System.out.println("Track " + i);
                    System.out.println(searchedItem.get(i - 1));
                    System.out.println();
                }

            } // if searched list size is zero
            else {
                System.out.println("There is no song matched with your keyword \n");
            }

        } // if play-list is empty
        else {

            System.out.println("Please add song first\n");
        }
    }

    // display list method
    public void displayList() {
        int size = playList.size();
        // if play list is not empty
        if (size > 0) {
            for (int i = 0; i < playList.size(); i++) {
                System.out.println("\nTrack " + (i + 1));
                System.out.println(playList.get(i));
            }
        } else {

            System.out.println("Please add song first\n");
        }

    }

    // calculates total playtime
    public void displayTotalPlayTime() {
        // songs string ex (title1, titele2, ...)
        String songs = "(";

        // total duration
        int totalDuartion = 0;

        // number of song in playList
        
        int count = playList.size();
        if(count>0) {
        for (int i = 0; i < count - 1; i++) {
            songs += playList.get(i).getTitle() + ", ";
            totalDuartion += playList.get(i).getDuration();
        }

        songs += playList.get(count - 1).getTitle() + ")";
        totalDuartion += playList.get(count - 1).getDuration();

        // convert total duration to hour:min:second formate
        int sec = totalDuartion % 60;
        int min = (totalDuartion / 60) % 60;
        int hours = (totalDuartion / 60) / 60;

        // if duration is in single digit append then append 0 before digit
        String strSecond = (sec < 10) ? "0" + Integer.toString(sec) : Integer.toString(sec);
        String strminute = (min < 10) ? "0" + Integer.toString(min) : Integer.toString(min);
        String strHours = (hours < 10) ? "0" + Integer.toString(hours) : Integer.toString(hours);

        System.out.println("\nTotal playtime for " + count + " songs \n " + songs);

        System.out.println("Duration in hour:minute:second  :  " + strHours + ":" + strminute + ":" + strSecond);
        }else System.out.println("Total playtime is 0.\n");

    }

}

 class Song {
public static void main(String[] args){
    private String title;
    private String artist;
    private String type;
    private int duration;


    // constructor
    public Song(String title, String artist, String type, int duration) {
        this.title = title;
        this.artist = artist;
        this.type = type;
        this.duration = duration;
    }

    // below all are getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // to String method to display song object
    @Override
    public String toString() {
        String title = String.format("\n%-20s : %s", "Title", this.title);
        String artist = String.format("\n%-20s : %s", "Artist", this.artist);
        String type = String.format("\n%-20s : %s", "Type", this.type);
        String duration = String.format("\n%-20s : %s", "Duration(seconds)", this.duration);
        StringBuilder sb = new StringBuilder().append(title).append(artist).append(type).append(duration + "\n");
        return sb.toString();
    }

}

