package com.yz.alg.leet;

/**
 * 
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.









Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 * 
 * @author zhzhyang
 *
 */
public class T037SudokuSolver {
	
	
	
	
	
	
    public void solveSudoku(char[][] board) {
      
 
        	 
    }
    
    private boolean checkSudokuPart(char[][] board,int indexRow,int indexCol){
         boolean checkBox =  checkSubBox( board,  indexRow,  indexCol);
         boolean checkCol = checkOneLineisSudoku(  board,  indexRow,  indexCol,false);
         boolean checkRow = checkOneLineisSudoku(  board,  indexRow,  indexCol,true);
         return checkBox && checkCol && checkRow;
    }
    
    
    
    private boolean checkSubBox(char[][] board,int indexRow,int indexCol){
    	boolean []  visitedCache = new boolean [9];
    	int startRow = indexRow/3;
    	int startCol = indexCol/3;
    	char value = 0;
    	int index = -1;
    	for(int i= 0; i< 3; i++){
    		for(int j=0; j< 3; j++){
    			value = board[startRow + i][ startCol+j];
    			if(value == '.')
    				continue;
    			else if(value <= '9' && value >= '1'){
    				index = value - '1';
    				if(visitedCache[index]){
    					return false;
    				}
    				else {
    					visitedCache[index] = true;
    				}
    						
    			}
    			else
    				return false;
    		}
    	}
    	
    	return true;
    }
    
    private boolean checkOneLineisSudoku(char[][] board,int indexRow,int indexCol,boolean isRow){
    	boolean []  visitedCache = new boolean [9];
    	char value = 0;
    	int index = -1;
    	for(int i=0; i<9; i++){
    		value = isRow ? board[indexRow][i] : board[i][indexCol];
    		if(value == '.')
    			continue;
    		else if( value >='1' && value <='9'){
    			index = value-'1';
    			if(visitedCache[index])
    				return false;
    			else {
    				visitedCache[index] = true;
    			}    			 
    		}
    		else
    			return false;
    	}    		
    	return true;
    } 
       
    
    private int [] getSort(char[][] board,boolean isRow){
    	int [] indexsort = new int[9];
    	int count = 0; // record the count of not '.' in one row 
    	int times [] = new int [9];
    	for(int i=0; i<9; i++){
    		count = 0;
    		for(int j=0; j<9; j++){
    			
    			if( isRow && board[i][j] != '.'  )
    				count++;
    			else if( !isRow && board[j][i] != '.' )
    				count++;
    			
    		}
    		times[i] = count;
    	}// end count
    	
    	// sort the count
    	int indexmax = 0;
    	for(int i=0; i<9; i++){
    		indexmax = findMax(times);
    		indexsort[i] = indexmax;
    		times[indexmax] = -1;
    	}
      return indexsort;
    }
     
    
    private int findMax(int times []){
    	int maxValue = -1;
    	int maxIndex = 0;
    	for(int i=0; i<times.length; i++){
    		if(times[i] > maxValue){
    			maxValue = times[i];
    			maxIndex = i;
    		}    		
    	}
    	return maxIndex;	
    }
    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
