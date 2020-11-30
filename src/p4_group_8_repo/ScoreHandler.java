package p4_group_8_repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreHandler {

	public ArrayList<ScoreType> scores;
	public ArrayList names;
	
	int score=0;
	
	Animal animal;
	
	public File file;
	
	public ScoreHandler() {
		
		scores = new ArrayList<ScoreType>();
		ArrayList<String> names = new ArrayList<String>();
		
		File file=new File("scoretext.txt");
		try {
			if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		readscores();
		

		
		
		
	}
	
	
	public void writescores(String username,int score,int level) {
		boolean found=false;
		
		for (int x=0;x<scores.size();x++) {	
			if(scores.get(x).Username.equals( username)) {
				if(scores.get(x).Score < score) {
				scores.get(x).Score=score;
				scores.get(x).Level=level;
				}
				found=true;
			}
		}
		if (!found) {
			scores.add(new ScoreType(username,score,level));
		}
	    
	   // scores.sort(Collections.reverseOrder());
	    try {
		    FileWriter myWriter = new FileWriter("scoretext.txt");
			for (int i=0;i<scores.size();i++) {		

				if (scores.get(i).Username!="") {
			    myWriter.write(scores.get(i).Username+"\n"+scores.get(i).Score+"\n"+scores.get(i).Level+"\n");
				}
			}
			myWriter.close();
	    }
		catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
	    }
		
	}
	
	public void readscores() {
		int second=1;
		String user="";
		int score=0;
		 try {
		      File myObj = new File("scoretext.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  String data = myReader.nextLine();
		    	  if(second==3) {
		    		  
				      scores.add(new ScoreType(user,score,Integer.valueOf(data)));
				      second=1;
		    	  }
		    	  else if (second==1) {
		    		  
		    		  second=2;
		    		  user=data;
		    	  }
		    	  else if (second==2) {
		    		  second=3;
		    		  score=Integer.valueOf(data);
		    	  }
		        
		       
		      }
		      myReader.close();
		    } 
		 catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public ArrayList getscore() {
		//readscores();
		return(scores);
	}
	
	public int gethiscore() {
		int hi=0;
		for(int i=0;i<scores.size();i++) {
			if (scores.get(i).Score>hi) {
				hi=scores.get(i).Score;
			}
		}
		return(hi);
	}
		
	
	
}
