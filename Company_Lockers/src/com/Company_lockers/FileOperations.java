package com.Company_lockers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileOperations {
	public static void CreatingDir(String folderName) {
		File file = new File(folderName);
		
		// we are creating file Lockers_file only if file is not present 
		if(!file.exists()) {
			file.mkdir();
		}
		
	}
	
	public static List<String> ListofFiles(String path, List<String> FilesNames ){
		File dir= new File(path);
		List<File> FileList= Arrays.asList(dir.listFiles());
		Collections.sort(FileList);
		
		if(FileList!=null) {

			for(File file:FileList) {
				System.out.println(file.getName());
			}
		   
			
		}
		else {
			System.out.println("empty");
		}
		return FilesNames;
	}
	 
	//Function to Display Files.
	public static void DisplayFiles(String path) {
		FileOperations.CreatingDir("Lockers_files");
		System.out.println("Displaying All the files in Ascending Order\n");
		
		
		List<String> FileListName = FileOperations.ListofFiles(path, new ArrayList<String>());
		Collections.sort(FileListName);
		
	  for(String file:FileListName) {
		  
		  System.out.println(file);
		  
	  }  
		
	}
	
	//Function to create files.
	 public static void Creatingfile(String addfile, Scanner sc1) {
		 FileOperations.CreatingDir("Lockers_files");
		
		 Path pathofFile =  Paths.get("C:\\Project_phase1\\Company_Lockers"+ "./Lockers_files/"+addfile);
		 
		 
		 try {
			Files.createDirectories(pathofFile.getParent());
			Files.createFile(pathofFile);
			System.out.println(addfile+" Created Succesfully");
			System.out.println("File Created in "+pathofFile);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Oops.. File Already Exists...Please use unique File Name");
		}
		 
		 
	 }
	 
	 //Function to delete files.
	 public static void DeletingFile(String filetoDelete, Scanner sc1) {
		 FileOperations.CreatingDir("Lockers_files");
		 Path pathofFile =  Paths.get("./Lockers_files/"+filetoDelete);
		 
		 try {
			Files.delete(pathofFile);
			System.out.println("File " +filetoDelete+" Deleted Succesfully..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file not present.. Please Enter Valid FileName");
		}
		 
	 }
	 
	 //Function to Search file.
	 public static void SearchingFile(String filetoSearch, Scanner sc1 ) {
		 FileOperations.CreatingDir("Lockers_files");
		 Path pathofFile =  Paths.get("C:\\Project_phase1\\Company_Lockers"+ "./Lockers_files/"+filetoSearch);
		 
		 try {
			Files.getFileStore(pathofFile);
			System.out.println("File Exists");
			System.out.println("Path of the file: "+pathofFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not present");
		}
		 
		 
		 
	 }
}
