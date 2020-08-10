
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
        int result = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            result *= 26;   //doing as in binary 
            result += (s.charAt(i) - 'A' + 1); //converting to ascii and adding 1 as A = 1
        }
        return result;
    }
	
	public static void main(String[] args) {
		String s = "AB";
		System.out.println(titleToNumber(s));
	}
}
