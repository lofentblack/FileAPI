package de.Schulschluss.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileAPI {

	static String filename;
	static String directory;
	static File file;

	public static String getFilename() {
		return filename;
	}

	public static void setFilename(String filename) {
		FileAPI.filename = filename;
	}

	public static String getDirectory() {
		return directory;
	}

	public static void setDirectory(String directory) {
		FileAPI.directory = directory;
	}

	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		FileAPI.file = file;
	}

	public void create_File(String name, String direct) {
		filename = name;
		directory = direct;
		try {
			file = new File(directory + "\\" + filename);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void write_in_next_free_line(String text) {
		try {
			FileWriter Writer = new FileWriter(file, true);
			Writer.write(text + "\n");
			Writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void write_override_all(String text) {
		try {
			FileWriter Writer = new FileWriter(file, false);
			Writer.write(text);
			Writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public ArrayList<String> read_all() {
		ArrayList<String> arr = new ArrayList<>();
		try {
			Scanner scn = new Scanner(file);
			while (scn.hasNext()) {
				arr.add(scn.nextLine());
			}
			scn.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return arr;
	}

	public String readline(int line) {
		String str = "none";
		try {
			Scanner scn = new Scanner(file);
			for (int i = 1; i <= line; i++) {
				if (scn.hasNext()) {
					str = scn.nextLine();
				}
			}

			scn.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return str;
	}
}
