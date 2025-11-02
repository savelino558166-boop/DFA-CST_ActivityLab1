package LabAct1_Avelino;
import java.util.Scanner;
import java.util.ArrayList;

public class DFA {
	
	static int Index, Current_State = 0;
	static String Q2 = "Unoccupied";
	
	
	/*
	 q0 -> 1 -> q0 
	 q0 -> 0 -> q1
	 
	 q1 -> 0 -> q0
	 q1 -> 1 -> q2
	 
	 q2 -> 1/0 -> q2
	 
	 */
	
	static void q0(char Pattern) {
		if (Pattern == '1') { 
			Index++ ;			//returns to itself
		} else if (Pattern == '0') {
			Index++ ;
			Current_State = 1;//goes to the next state

		}
		
	}
	
	static void q1(char Pattern) {
		if (Pattern == '1') {
			Index++;
			Current_State = 2;//goes to the Accept state
			Q2 = "Occupied";
		} else if (Pattern == '0') {
			Index++;
			Current_State = 0;	//return to Q0	
		}
		
	}
	
	static void q2Accept(char Pattern) {
		if (Pattern == '1' || Pattern == '0') {				//Just returns to itself
			Index++;
			
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("DFA \nInput: ");
		String Input_strings = scn.next();
		
		scn.close();
		
		ArrayList<Character> Whole_strings = new ArrayList<Character>();		//it will adjust to the size of the strings given
		
		//putting the whole strings inside an array so it can be called later
		for (int counter = 0; counter <= (Input_strings.length() -1); counter++) {
			Whole_strings.add(Input_strings.charAt(counter));

		}
		
		
			
			try {
			
				while (Index < Input_strings.length()) {
					
				
					if (Current_State == 0) {
						q0(Whole_strings.get(Index));
				
					}	else if (Current_State == 1) {
						q1(Whole_strings.get(Index));

					}	else if (Current_State ==2) {
						q2Accept(Whole_strings.get(Index));
				
					}
			
				} // the Loop
			
			} finally {
				if (Q2.equals("Occupied")){
					System.out.println("Accept");
					
				} else {
					System.out.println("Reject");
				}
				

			}
				
	}
}