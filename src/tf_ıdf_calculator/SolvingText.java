package tf_�df_calculator;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SolvingText {
	
	public static String clearText(String str) {
		
		String str1 = str.replace(",", "").replace("  ", " ").replace(".", "").replace(")", "").replace("(", "").replace("\n", "");
		//String str2 = str1.replace(".", "");
		//String str3 = str2.replace(")", "");
		//String str4 = str3.replace("(", "");
		
		return str1;
	}
	
	//This method take list of documents and term.The method will find out how many.
	public static double InverseTermFrequency(List<List<String>> docs , String term) {
		double n=0;
		
		for(List<String> doc : docs) {
			for(String word : doc) {
				if(term.equalsIgnoreCase(word)) {
					n++;
					break;
				}
			}
		}
		System.out.println("N value : "+ n);
		System.out.println("Documents size : "+docs.size());
		return Math.log((docs.size())/n);
	}
	
	public static double TermFrequency(List<String> doc,String term) {
		double result = 0;
		for(String word : doc) {
			if(term.equalsIgnoreCase(word)) {
				result++;
			}
		}
		return (result/ MaxNumberOfWords(doc));
	}
	
	public static int MaxNumberOfWords(List<String> doc) {
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i=0;i<doc.size();i++) {
			String word = doc.get(i);
			int num=0;
			for(String words : doc) {
				if(word.equalsIgnoreCase(words)) {
					num++;
				}
			}
			map.put(word,num);
		}
		int maxValueInMap = Collections.max(map.values()); //This will return max value in the HashMap
		for(Entry<String , Integer> entry : map.entrySet()) { //Itarate through hashmap
			if(entry.getValue()==maxValueInMap) {
				System.out.println(entry.getKey() + " --- " + entry.getValue()); // Print the key with max value
			}
		}
		
		return maxValueInMap;
	}
	
	public static void main(String[] args) {
		
		//------------------------Term Frequecny is starting----------------------------
		
		String str1 = "Javada bir String bir de�erini belli bir kurala g�re par�alamak, b�lmek "
				+ ",gerekti�inde .split() �zelli�ini kullanarak bir i�leminizi yapabilirsiniz.";
		
		String str2 = "IDF hesab� s�ras�nda bir iki noktaya dikkat etmek gerekir. \n" + 
				"�ncelikle logaritman�n taban�n�n javada bir �nemi yoktur. Ama� �ssel fonksiyonun \n" + 
				"tersi y�nde bir hesap yapmakt�r.";
		
		String str3 = "Bunlardan birincisi o anda ele al�nan dok�mandaki terimin say�s� \n" + 
				"di�eri ise bu terimi k�lliyatta i�eren toplam dok�man say�s�d�r.";
		
		String str4 = "Ard�ndan IDF de�erini hesaplayal�m. Bunun i�in basit bir b�lme \n" + 
				"i�lemi yap�lacak ve logaritmas� al�nacakt�r.";
		
		String str5 = "Bu durumda sonu� s�f�ra b�l�m belirsizli�ine g�t�rebilece�inden \n" + 
				"genelde bu de�ere 1 eklemek s�k�a javada yap�lan bir programlama yakla��m�d�r.";
		
		String str6 = "Yukar�daki g�sterimde, i terimi i�in ve d dok�man� i�in hesaplama \n" + 
				"yap�lmaktad�r. �ncelikle TF hesaplan�r ki bu basit�e terimin o dok�manda \n" + 
				"ka� kere ge�ti�inin en fazla ge�en terime oran� �eklinde hesaplanabilir.";
		
		String str7 = "Yani i terimi i�in d dok�man�ndaki terim frekans� (term frequency), \n" + 
				"i teriminin d dok�man�ndaki tekrar javada say�s�n�n o dok�mandaki en y�ksek tekrar \n" + 
				"say�s�na sahip terimin tekrar say�s�na oran�d�r. Veya bu oranlar�n en \n" + 
				"y�kse�idir.";
		
		String str8 = "Yukar�da verilen TF-IDF form�l�nde ayr�ca n toplam dok�man say�s�n� \n" + 
				"df ise dok�man frekans�n� vermektedir ve df asl�nda i teriminin ka� farkl� \n" + 
				"dok�manda ge�ti�inin say�s�d�r.";

		String str9 = "Son olarak TF-IDF y�nteminin di�er y�ntemlere g�re fark�n� \n" + 
				"a��klamaya �al��al�m. TF-IDF ile bir terimin ka� kere ge�ti�i kadar \n" + 
				"ka� farkl� dok�manda da ge�ti�i �nem kazan�r.";
		
		String str10 = "�kisi de do�rudur. Yani toplam terim say�s� veya en fazla ge�en \n" + 
				"terim say�s� (kaynaklarda ikisi de ge�iyor) ve asl�nda �ok da �nemi yok. ";
	      
		 String[] text = clearText(str1).toLowerCase().split(" ");
		 List<String> words = new ArrayList<String>();
		 
		 for(int i=0;i<text.length;i++) {
			 words.add(text[i]);
		 }
		 
		 for(int i=0;i<words.size();i++) {
			 System.out.println(i + ". words : " + words.get(i));
		 }
		 
		 System.out.println("Term Frequency value : " + TermFrequency(words,"javada"));
		 System.out.println("Maxiumum number of word : " + MaxNumberOfWords(words));
		 
		 //------------------------Term Frequecny finished----------------------------
		 
		 //--------------------Inverse Document Frequency is starting------------------
		 
		 List<String> texts = new ArrayList<String>();
		 texts.add(clearText(str1).toLowerCase());
		 texts.add(clearText(str2).toLowerCase());
		 texts.add(clearText(str3).toLowerCase());
		 texts.add(clearText(str4).toLowerCase());
		 texts.add(clearText(str5).toLowerCase());
		 texts.add(clearText(str6).toLowerCase());
		 texts.add(clearText(str7).toLowerCase());
		 texts.add(clearText(str8).toLowerCase());
		 texts.add(clearText(str9).toLowerCase());
		 texts.add(clearText(str10).toLowerCase());
		
		
		 List<List<String>> documents = new ArrayList<>();
		

		for(int i=0;i<texts.size();i++) {
			System.out.println(texts.get(i));
			String[] wrds = texts.get(i).split(" ");
			System.out.println("Line count is " + wrds.length);
			System.out.println("-----------------------------------------------------------------");
			List<String> wordsOftext = new ArrayList<>();
			for(int k=0;k<wrds.length;k++) {
				wordsOftext.add(wrds[k]);
			}
			documents.add(wordsOftext);
		}
		
		System.out.println("IDF value : " + InverseTermFrequency(documents, "javada"));
		
		for(int i=0;i<documents.size();i++) {
			for(int k=0;k<documents.get(i).size();k++) {
				System.out.println(k+". word of "+i+". list value : " + documents.get(i).get(k));
			}
		}
		 
	}
	
}
