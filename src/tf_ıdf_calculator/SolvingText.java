package tf_ýdf_calculator;

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
		
		String str1 = "Javada bir String bir deðerini belli bir kurala göre parçalamak, bölmek "
				+ ",gerektiðinde .split() özelliðini kullanarak bir iþleminizi yapabilirsiniz.";
		
		String str2 = "IDF hesabý sýrasýnda bir iki noktaya dikkat etmek gerekir. \n" + 
				"Öncelikle logaritmanýn tabanýnýn javada bir önemi yoktur. Amaç üssel fonksiyonun \n" + 
				"tersi yönde bir hesap yapmaktýr.";
		
		String str3 = "Bunlardan birincisi o anda ele alýnan dokümandaki terimin sayýsý \n" + 
				"diðeri ise bu terimi külliyatta içeren toplam doküman sayýsýdýr.";
		
		String str4 = "Ardýndan IDF deðerini hesaplayalým. Bunun için basit bir bölme \n" + 
				"iþlemi yapýlacak ve logaritmasý alýnacaktýr.";
		
		String str5 = "Bu durumda sonuç sýfýra bölüm belirsizliðine götürebileceðinden \n" + 
				"genelde bu deðere 1 eklemek sýkça javada yapýlan bir programlama yaklaþýmýdýr.";
		
		String str6 = "Yukarýdaki gösterimde, i terimi için ve d dokümaný için hesaplama \n" + 
				"yapýlmaktadýr. Öncelikle TF hesaplanýr ki bu basitçe terimin o dokümanda \n" + 
				"kaç kere geçtiðinin en fazla geçen terime oraný þeklinde hesaplanabilir.";
		
		String str7 = "Yani i terimi için d dokümanýndaki terim frekansý (term frequency), \n" + 
				"i teriminin d dokümanýndaki tekrar javada sayýsýnýn o dokümandaki en yüksek tekrar \n" + 
				"sayýsýna sahip terimin tekrar sayýsýna oranýdýr. Veya bu oranlarýn en \n" + 
				"yükseðidir.";
		
		String str8 = "Yukarýda verilen TF-IDF formülünde ayrýca n toplam doküman sayýsýný \n" + 
				"df ise doküman frekansýný vermektedir ve df aslýnda i teriminin kaç farklý \n" + 
				"dokümanda geçtiðinin sayýsýdýr.";

		String str9 = "Son olarak TF-IDF yönteminin diðer yöntemlere göre farkýný \n" + 
				"açýklamaya çalýþalým. TF-IDF ile bir terimin kaç kere geçtiði kadar \n" + 
				"kaç farklý dokümanda da geçtiði önem kazanýr.";
		
		String str10 = "Ýkisi de doðrudur. Yani toplam terim sayýsý veya en fazla geçen \n" + 
				"terim sayýsý (kaynaklarda ikisi de geçiyor) ve aslýnda çok da önemi yok. ";
	      
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
