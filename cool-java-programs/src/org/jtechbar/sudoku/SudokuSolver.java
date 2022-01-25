package org.jtechbar.sudoku;

import java.util.HashSet;

public class SudokuSolver {
	
	public boolean solveSudoku(int[][] sudokuArray, HashSet validSet) {
		int number=0,size=sudokuArray.length;
		for(int row=0;row<size;row++) {
			for(int column=0;column<size;column++) {
				number=sudokuArray[row][column];
				if(number==0) {
					for(int cellValue=1;cellValue<=9;cellValue++) {
						if(validSet.contains(cellValue+"inrow"+row) || validSet.contains(cellValue+"incol"+column) || validSet.contains(cellValue+"inbox"+(row/3)+(column/3))) {
							continue;
						}else {
							validSet.add(cellValue+"inrow"+row);
							validSet.add(cellValue+"incol"+column);
							validSet.add(cellValue+"inbox"+(row/3)+(column/3));
							sudokuArray[row][column]=cellValue;
							if(solveSudoku(sudokuArray,validSet)) {
								return true;
							}else {
								validSet.remove(cellValue+"inrow"+row);
								validSet.remove(cellValue+"incol"+column);
								validSet.remove(cellValue+"inbox"+(row/3)+(column/3));
								sudokuArray[row][column]=0;
							}
						}
					}
					
					return false;
				}
				
				
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		int[][] sudokuArray = {
				{5,3,6,2,1,4,8,9,7},
				{4,1,7,3,8,9,2,5,6},
				{2,9,8,5,6,7,3,4,1},
				{3,2,4,1,7,6,9,8,5},
				{1,8,5,4,0,2,6,0,3},
				{6,7,9,8,3,5,1,2,4},
				{7,4,0,6,2,8,5,3,9},
				{8,5,3,9,0,1,7,6,2},
				{9,6,0,7,5,3,4,0,0}
			  };
		
		HashSet<String> validSet = new HashSet<>();
		
		SudokuValidator validator=new SudokuValidator();
		if(validator.isValidSudoku(sudokuArray, validSet)) {
			new SudokuSolver().solveSudoku(sudokuArray, validSet);
			validSet = new HashSet<String>();
			validator.isValidSudoku(sudokuArray, validSet);
			new SudokuDisplay().display(sudokuArray);
		}

	}

}
