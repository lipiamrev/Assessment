package com.manthan.musicplayer.main;

import java.util.Scanner;

import com.manthan.musicplayer.jdbc.MusicPlayerJDBC;


public class MusicPlayerRun extends Thread {

	public static void main(String[] args) {

		MusicPlayerJDBC music_player_jdbc = new MusicPlayerJDBC();

		int options;
		String sub_options;
		String update;
		String update1;
		int song_id;
		String song_name;
		String artist;
		boolean flag=true;

		System.out.println("MUSIC PLAYER");

		do {
			System.out.println("Please select an option");
			System.out.println("1. Play a song\n"
					+ "2. Search a song\n"
					+ "3. Show all songs\n"
					+ "4. Operate on songs database\n"
					+ "5. To exit press 0");

			Scanner sc = new Scanner(System.in);
			options =sc.nextInt();

			switch (options) {

			case 1:
				System.out.println("A. Play all songs\n"
						+ "B. Play songs randomly\n"
						+ "C. Show songs");

				Scanner sc1 = new Scanner(System.in);
				sub_options = sc1.next();

				switch (sub_options) {

				case "A":
					music_player_jdbc.allSongs();
					break;

				case "B":
					music_player_jdbc.randomSongs();
					break;

				case "C":
					music_player_jdbc.searchSongs();

					try {
						System.out.println("Song is Playing");
						Thread.sleep(10000);
						System.out.println("Song Stopped");
					}
					catch (Exception e) {
						e.printStackTrace();
					}

					break;

				default: System.out.println("Invalid Option");
				break;
				}

				break;
			case 2:
				music_player_jdbc.searchSongs();
				break;

			case 3:
				music_player_jdbc.allSongs();
				break;

			case 4:
				System.out.println("Add/Edit/Delete Songs");
				System.out.println("If want to add song press 'A'\n"
						+ "If want to edit song press 'B'\n"
						+ "If want to delete song press 'C'");

				Scanner sc2 = new Scanner(System.in);
				update = sc2.next();

				if(update.compareTo("A")==0) {
					System.out.println("\n Enter song id, song name, artist ");
				
					music_player_jdbc.addSongs();
				}

				if(update.compareTo("B")==0) {

					System.out.println("Update song artist press '1'");

					Scanner sc3 = new Scanner(System.in);
					update1 = sc3.next();

					if(update1.compareTo("1")==0) {
						System.out.print("\n Enter song name: ");

						Scanner sc4 = new Scanner(System.in);
						song_name = sc4.next();

						System.out.print("\n Updated artist name: ");

						Scanner sc5 = new Scanner(System.in);
						artist = sc5.next();

						music_player_jdbc.updateSong(artist, song_name);
					}
				}

				if(update.compareTo("d")==0) {
					music_player_jdbc.deleteSong();
				}

				break;

			case 0:
				flag=false;

				break;

			default:
				System.out.println("Invalid Option");
				break;

			}
		}

		while(flag);
		System.out.println("Thank You");

	}

}