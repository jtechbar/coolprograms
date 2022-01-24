package org.jtechbar.sudoku;

import java.util.HashSet;

public class SudokuValidator {
	
	public boolean isValidSudoku(int[][] sudokuArray) {
		HashSet<String> validSet = new HashSet<>();
		int number=0,length = sudokuArray.length;
		for(int row=0;row<length;row++) {
			for(int column=0;column<length;column++) {
				number = sudokuArray[row][column];
				if(number!=0) {
					if(!(validSet.add(number+"inrow"+row) || !(validSet.add(number+"incol"+column))) || !(validSet.add(number+"inbox"+(row/3)+(column/3)))) {
						System.out.printf("Invalid Sudoku!! Invalid value %d found at (%d,%d)",number,(row+1),(column+1));
						return false;
					}
					
				} 
			}
		}
		
		System.out.println("Valid Sudoku. :)");
		
		return true;
	}
	

	public static void main(String[] args) {
		int[][] sudokuArray = {
								{5,3,6,2,1,4,8,9,7},
								{4,1,7,3,8,9,2,5,6},
								{2,9,8,5,6,7,3,4,1},
								{3,2,4,1,7,6,9,8,5},
								{1,8,5,4,9,2,6,7,3},
								{6,7,9,8,3,5,1,2,4},
								{7,4,1,6,2,8,5,3,9},
								{8,5,3,9,4,1,7,6,2},
								{9,6,2,7,5,3,4,1,0}
							  };
		
		SudokuValidator validator = new SudokuValidator();
		System.out.println(validator.isValidSudoku(sudokuArray));
	}	

}
