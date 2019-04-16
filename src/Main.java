import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="AAAAAAAAKKKKMMMT".toLowerCase();
		int value=0;
		while(value<str.length()){
			rearrange(str,value);
			value++;
		}
	}


	static void rearrange(String str,int value){

		int length=str.length();

		int count[]=new int[26];
		for(int i=0;i<length;i++){
			count[str.charAt(i)-'a']++;
		}

		PriorityQueue<Key> pq=new PriorityQueue<>(new KeyComparator());



		for(char c='a';c<='z';c++){
			int val=c-'a';


			if(count[val]>0){

				pq.add(new Key(count[val],c));

			}
		}

		/*		System.out.println("======================="+str);

		pq.forEach(k->System.out.println((char)k.ch+" "+k.freq));*/
		char[] resArr=new char[str.length()];
		int pqSize=pq.size();
		List<Integer> emptyPositions=new ArrayList<>();
		List<Integer> filledPositions=new ArrayList<>();
		List<Integer> notFilledPositions=new ArrayList<>();
		int emptyPos=0;

		while(emptyPos < str.length()){
			emptyPositions.add(emptyPos);
			emptyPos++;
		}
		int listIndex=2;
		for(int i=0;i<pqSize;i++){
			Key charObj=pq.peek();
			pq.poll();
			//start position
			emptyPositions.removeAll(filledPositions);
			if(emptyPositions.size() < str.length()){
				notFilledPositions.removeAll(filledPositions);
				emptyPositions=notFilledPositions;
				notFilledPositions= new ArrayList<>();		
				listIndex=0;
			}else{
				listIndex=value;
			}
			//emptyPositions.removeAll(filledPositions);

			filledPositions=new ArrayList<>();


			for(int k=0;k<charObj.freq;k++){

				if(listIndex>=emptyPositions.size()){
					listIndex=listIndex-emptyPositions.size();
				}
				/*if(listIndex>emptyPositions.size()){
					listIndex=listIndex-emptyPositions.size()+1;
				}*/
				int pos=emptyPositions.get(listIndex);
				while(filledPositions.contains(pos)){
					listIndex++;
					pos=emptyPositions.get(listIndex);
				}

				resArr[pos]=(char) charObj.ch;
				filledPositions.add(pos);
				listIndex++;
				if(listIndex >=emptyPositions.size()){
					notFilledPositions.add(listIndex-emptyPositions.size());
				}else{
					notFilledPositions.add(emptyPositions.get(listIndex));
				}
				listIndex++;

			}


		}
		System.out.println(Arrays.toString(resArr));


	}
}


