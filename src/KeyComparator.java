import java.util.Comparator;

public class KeyComparator implements Comparator<Key> {

	@Override
	public int compare(Key k1, Key k2) {
		// TODO Auto-generated method stub
		
		if(k1.freq < k2.freq){
			return 1;
		}
		if(k1.freq > k2.freq){
			return -1;
		}
		
		return 0;
	}

}
