package n_gram_examples;

import java.util.Vector;

class Counter{
	int num;
	String ngram;
	
	public Counter(){
	}
	
	public Counter(int num,String ngram) {
		this.num=num;
		this.ngram=ngram;
	}
}

public class TextTest {
	public static void main(String[] args) {
		
		String text = "wwwbilgisayarkavramlaricomsadievrenseker";
		Vector v = new Vector();
		int n=2;
		for(int i=0;i<text.length()-n+1;i++) {
			String x = text.substring(i, i+n);
			boolean found=false;
			for(int k=0;k<v.size();k++) {
				Counter c = (Counter) v.elementAt(k);
				if(x.equals(c.ngram)) {
					found=true;
					c.num++;
				}
			}
			
			if(!found) {
				v.add(new Counter(1,x));
			}
		}
		
		for(int i=0;i<v.size();i++) {
			Counter c = (Counter) v.elementAt(i);
			System.out.println(c.ngram + " ; " + c.num);
		}
		
	}
}
