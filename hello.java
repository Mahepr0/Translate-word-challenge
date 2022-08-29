package servletfirst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class hello{

	public static void main(String[] args) throws IOException {
		 long start=Instant.now().toEpochMilli();
		 long firstmem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		 
	     String filePath = "D:\\New folder\\t8.shakespeare.txt";
	     BufferedReader br = new BufferedReader(new FileReader(filePath));
	     StringBuffer buffer = new StringBuffer();
	     
	    String line = null;
		String ls = System.getProperty("line.separator");
		while ((line = br.readLine()) != null) {
				buffer.append(line);
				buffer.append(ls);
			}
		buffer.deleteCharAt(buffer.length() - 1);
		br.close();
		String fileContents = buffer.toString();
	    
	    //System.out.println("Contents of the file: "+fileContents);
	     
	    String wordPath = "D:\\New folder\\find_words.txt";
		BufferedReader br1 = new BufferedReader(new FileReader(wordPath));
		StringBuffer buffer1 = new StringBuffer();
		
		String line1 = null;
		String ls1 = System.getProperty("line.separator");
		while ((line1 = br1.readLine()) != null) {
				buffer1.append(line1);
				buffer1.append(ls1);
			}
		buffer.deleteCharAt(buffer.length() - 1);
		br.close();
		String findWords = buffer1.toString();
	    
		//System.out.println(findWords);
		
		List<String> findWordsList = new ArrayList<String>(Arrays.asList(findWords.split("\\r?\\n")));
		
		String pathCsv = "D:\\New folder\\french_dictionary.csv";
		BufferedReader br2 = new BufferedReader(new FileReader(pathCsv));
		String line2 = null;
		HashMap<String, String> map = new HashMap<String, String>();
		while ((line2 = br2.readLine()) != null) {
			String str[] = line2.split(",", 2);
			//System.out.println(str[1]);
			//map.put(str[0], line2.substring(str[0].length() + 1));
			map.put(str[0], str[1]);
		}
		//System.out.println(findWordsList);
	      
		List<String> uniqueWords=new ArrayList<String>(); //unique words
		
		HashMap<String,Integer> countFreq=new HashMap<>(); //frequency of unique words
		
//		String sample="";
//		try {
//		for(int i=0;i<fileContents.length();i++) {
//			sample="";
//			int tempint=i;
//			while(fileContents.charAt(i)!=' ') {
//				sample=sample+fileContents.charAt(i);
//				i++;
//				
//			}
//			sample=sample.toLowerCase();
//			//System.out.println(sample);
//			if(findWordsList.contains(sample)) {
//				uniqueWords.add(sample);
//				if(countFreq.containsKey(sample)) {
//					countFreq.put(sample, countFreq.get(sample)+1);
//				}
//				else {
//					countFreq.put(sample, 1);
//				}
//				//System.out.println(fileContents);
//				fileContents=fileContents.replace(fileContents.substring(tempint,i), map.get(sample));
//			}
//			
//		}
//		}
//		
//		catch (StringIndexOutOfBoundsException e) {
//			System.out.println("Error"+fileContents.length());
//		}
		
	      
	    long end=Instant.now().toEpochMilli();
		long totaltime=end-start;
		
		long lastmem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long totalmem=lastmem-firstmem;
		
		System.out.println(fileContents);
		System.out.println("Total time taken: "+totaltime+"ms");
		System.out.println("Memory used: "+totalmem+"MB");
	      
	}

}
