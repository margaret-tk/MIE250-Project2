package linalg;

/*** A class that represents a two dimensional real-valued (double) matrix
 *   and supports various matrix computations required in linear algebra.
 *   
 *   Class and method comments are in JavaDoc: https://en.wikipedia.org/wiki/Javadoc
 * 
 * @author scott.sanner@utoronto.ca, <YOUR_EMAIL>
 *
 */
public class Matrix {

	private int _nRows; // Number of rows in this matrix; nomenclature: _ for data member, n for integer
	private int _nCols; // Number of columns in this matrix; nomenclature: _ for data member, n for integer
	private double[][] _2dimadVal; //2 dimensional array double value
		
	/** Allocates a new matrix of the given row and column dimensions
	 * 
	 * @param rows
	 * @param cols
	 * @throws LinAlgException if either rows or cols is <= 0
	 */
	public Matrix(int rows, int cols) throws LinAlgException {
		if(rows <= 0 || cols <= 0) throw new LinAlgException("Can't be less than zero ");
		_nRows = rows;
		_nCols = cols;
		_2dimadVal = new double[rows][cols]; //makes all values 0.0 
	}
	
	/** Copy constructor: makes a new copy of an existing Matrix m
	 *                    (note: this explicitly allocates new memory and copies over content)
	 * 
	 * @param m
	 */
	public Matrix(Matrix m) {
		_nRows = m._nRows;
		_nCols = m._nCols;
		_2dimadVal = new double[_nRows][_nCols]; //allocates 2d array size _nRows x _nCols
		for (int indexRows = 0; indexRows < _nRows; indexRows++) {
			for (int indexCols = 0; indexCols < _nCols; indexCols++) {
				_2dimadVal[indexRows][indexCols] = m._2dimadVal[indexRows][indexCols];
			}
		}
	}
	

	/** Constructs a String representation of this Matrix
	 * 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();		
		for (int i = 0; i< _nRows ; i++) { //loop through rows
			sb.append("["); //start of each row is an open bracket 
			for (int j=0; j < _nCols; j++) { //loops through columns and converts to strings 
				sb.append(String.format(" %6.3f ", _2dimadVal[i][j]));
			}
			sb.append(" ] \n"); //ends row with a closed bracket and a new line 
		}
		return sb.toString();
	}

	/** Tests whether another Object o (most often a matrix) is a equal to *this*
	 *  (i.e., are the dimensions the same and all elements equal each other?)
	 * 
	 * @param o the object to compare to
	 */
	public boolean equals(Object o) {  
		if (o instanceof Matrix) {
			Matrix m = (Matrix)o;
			
			if ((_nRows != m._nRows) || (_nCols != m._nCols) ) return false; //matrices can't be equal if they have different number of rows or columns 
			for (int i = 0; i < _nRows ; i++) { //loops through rows
				for (int j = 0; j < _nCols ; j++) { //loops through columns 
					if (_2dimadVal[i][j] != m._2dimadVal[i][j]) return false; //some value at some index i,j didn't match 
				}
			}
			return true; //Everything matched 
		}
		else return false; // Two objects cannot be equal if they don't have the same class type
	}
	
	
	/** Return the number of rows in this matrix
	 *   
	 * @return 
	 */
	public int getNumRows() { 
		return _nRows;
	}

	/** Return the number of columns in this matrix
	 *   
	 * @return 
	 */
	public int getNumCols() { 
		return _nCols;
	}

	/** Return the scalar value at the given row and column of the matrix
	 * 
	 * @param row
	 * @param col
	 * @return
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public double get(int row, int col) throws LinAlgException { 
		if (row >= _nRows|| row < 0 || col >=_nCols || col <0) throw new LinAlgException("stuff is out of bounds");//if column or row out of bound, throw exception 
		return _2dimadVal[row][col];
	}
	
	/** Return the Vector of numbers corresponding to the provided row index
	 * 
	 * @param row
	 * @return
	 * @throws LinAlgException if row is out of bounds
	 */
	
	public Vector getRow(int row) throws LinAlgException {  
		if (row >= _nRows || row < 0) throw new LinAlgException("message"); 
		Vector rowVector = new Vector(_nCols); //allocates space for a vector that has the same number of indices as columns in the matrix, initialized to zero 
	    //double[] values = rowVector.getVal(); //
		for (int j = 0 ; j < _nCols ; j++) {
			//System.out.print(_2dimadVal[row][j]);
			rowVector.getVal()[j] = _2dimadVal[row][j]; 
		}
		return rowVector;
	}

	/** Set the row and col of this matrix to the provided val
	 * 
	 * @param row
	 * @param col
	 * @param val
	 * @throws LinAlgException if row or col indices are out of bounds
	 */
	public void set(int row, int col, double val) throws LinAlgException { //tentatively done and tested 
		if ( row > _nRows-1 || row < 0 || col > _nCols-1 || col < 0) throw new LinAlgException("out of bounds");
		_2dimadVal[row][col] = val; //set number at row,col index to val 
	}
	
	/** Return a new Matrix that is the transpose of *this*, i.e., if "transpose"
	 *  is the transpose of Matrix m then for all row, col: transpose[row,col] = m[col,row]
	 *  (should not modify *this*)
	 * 
	 * @return
	 * @throws LinAlgException
	 */
	public Matrix transpose() throws LinAlgException {
		Matrix transpose = new Matrix(_nCols, _nRows);
		for (int row = 0; row < _nRows; row++) {
			for (int col = 0; col < _nCols; col++) {
				transpose.set(col, row, get(row,col));
			}
		}
		return transpose;
	}

	/** Return a new Matrix that is the square identity matrix (1's on diagonal, 0's elsewhere) 
	 *  with the number of rows, cols given by dim.  E.g., if dim = 3 then the returned matrix
	 *  would be the following:
	 *  
	 *  [ 1 0 0 ]
	 *  [ 0 1 0 ]
	 *  [ 0 0 1 ]
	 * 
	 * @param dim
	 * @return
	 * @throws LinAlgException if the dim is <= 0
	 */
	public static Matrix GetIdentity(int dim) throws LinAlgException { //tentative done and tested 
		if (dim <= 0) throw new LinAlgException("Dimension " + dim + "cannot be less than or equal to zero"  );
		Matrix identity = new Matrix(dim,dim); //allocate memory for new matrix dim rows x dim cols
		for (int i = 0; i < dim; i ++) { //loop through each row 
			identity._2dimadVal[i][i] = 1;  // set row=i, col=i to 1 (these are the diagonal values)
		}
		return identity; //return new matrix
	}
	
	/** Returns the Matrix result of multiplying Matrix m1 and m2
	 *  (look up the definition of matrix multiply if you don't remember it)
	 * 
	 * @param m1
	 * @param m2
	 * @return
	 * @throws LinAlgException if m1 columns do not match the size of m2 rows
	 */
	public static Matrix Multiply(Matrix m1, Matrix m2) throws LinAlgException {
		if(m1._nCols != m2._nRows) throw new LinAlgException("cols of m1 don't mathc rows of m2");
		Matrix result = new Matrix(m1._nRows, m2._nCols);
		Matrix t_m2 = m2.transpose(); //t_m2 is transposed m2
		for(int i =0; i < m1._nRows ; i++) { //loops through rows of m1
			for(int j = 0; j < t_m2._nRows ; j++) { //loops through rows of transposed m2
				for(int k = 0; k < m1._nCols; k++) { //loops through columns of both (number is same) 
					result._2dimadVal[i][j] = result._2dimadVal[i][j] + (m1._2dimadVal[i][k] * t_m2._2dimadVal[j][k]); 
				}
			}
		}
		return result;
	}
		
	/** Returns the Vector result of multiplying Matrix m by Vector v (assuming v is a column vector)
	 * 
	 * @param m
	 * @param v
	 * @return
	 * @throws LinAlgException if m columns do match the size of v
	 */
	public static Vector Multiply(Matrix m, Vector v) throws LinAlgException {
		if(m._nCols != v.getDim()) throw new LinAlgException("message ");
		Vector result = new Vector(m._nRows); //new vector dimension # of rows of vector 
		double val;
		for (int i = 0; i < m._nRows; i ++) {  //count through rows of matrix 
			val = 0; //initialize value 
			for (int j = 0 ; j < v.getDim(); j++) { //count through values of vector and columns of matrix 
				val = val + m._2dimadVal[i][j] * v.getVal()[j];
				result.set(i, val); //set values in new vector 
			}
		}
			return result;
	}

}
