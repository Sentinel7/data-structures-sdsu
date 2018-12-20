
public class TestHashCode {

	public long hashCode(String s) {
		int g = 31;
		long code = 0;
		
		for(int i=0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			code += c * Math.pow(g, i);
		}
		
		return code;
	}
	
	public static void main(String[] args) {
		
		// Testing
		System.out.println(Integer.toBinaryString(0x8F55C)); // hex to binary
		System.out.println(String.format("%02X", 0b10001111010101011100)); // binary to hex

		System.out.println(Integer.toBinaryString(-10)); // negative number has an extra 1 in front
		System.out.println(Integer.toBinaryString(0x7FFFFFFF)); // 0111 1111 1111 ... 1111 & another number, it turns it positive
		
		
		
		int tablesize = 31;
		String[] hashtable = new String[tablesize];
		
		TestHashCode data = new TestHashCode();
		String ss = "Jason Thomo";
		
		long hashval = data.hashCode(ss); //get a hashcode for a given string, ss 
		hashval = hashval & 0x7FFFFFFF;   //turn to a positive number using 2-complement. If positive, it doesn't change.
		hashval = hashval % tablesize;    //compressing hashvalue to fit size of the array
		hashtable[(int)hashval] = ss;	  //store the string in hash array
		
		
		//let's print hash array
		for (int ii=0; ii<tablesize; ii++) {
			System.out.println("hashtable[" + ii + "] = " + hashtable[ii]);
		}
		
	}

}
