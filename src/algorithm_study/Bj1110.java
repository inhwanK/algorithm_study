package algorithm_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj1110 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		int check = Integer.parseInt(input);
		
		if(check < 10){
			input = input + "0";
		}
		
		String first = input;
		int count = 0;
		while(true){
			int A = input.charAt(0) - '0';
			int B = input.charAt(1) - '0';
			
			System.out.println(A);
			System.out.println(B);
			
			String a = B + "";
			String b = (A+B) + "";
			
			if(b.length()>1) {
				b = b.charAt(1)+"";
			}
			
			input  = a+b;
			
			System.out.println(input);
			
			count++;
			
			System.out.println("count = " +  count);
			if(first.equals(input)){
				bw.write(count+"");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
