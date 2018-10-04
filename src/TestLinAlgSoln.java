import soln.linalg.LinAlgException;
import soln.linalg.Matrix;
import soln.linalg.Vector;

/** This is a small example of test cases.  Write your own test cases to understand all
 *  of the methods in Matrix and Vector.  To test correctness of your implementation,  
 *  see if the output on your tests matches the results of the same tests on the solution
 *  (e.g., see TestLinAlgSoln which provides results for the solution by importing 
 *         soln.Matrix and soln.Vector as opposed to linalg.Matrix and linalg.Vector
 *         that you are writing).
 * 
 * @author ssanner@mie.utoronto.ca
 *
 */
public class TestLinAlgSoln {

	public static void main(String[] args) {
		try {
			// Note: you need to write your own tests, this is only a small sample and it does not
			//       test all cases that throw an Exception as required by JavaDoc comments.
			Vector v = new Vector("[ 1 2 3 4 5 ]");
			System.out.println("1. test constructor and toString(): " + v); // This automatically invokes v.toString()!
			System.out.println("2. test scalar addition: " + v.scalarAdd(1));
			System.out.println("3. ensure v was not modified: " + v);
			v.scalarAddInPlace(2);
			System.out.println("4. now v should be modified: " + v);
			
			//testing scalar add that shouldn't modify old one but makes new one 
			//Vector l = v.scalarAdd(1);
			//System.out.println(l);
			
			//test vector constructor 
			//System.out.println("testing allocating new memory");
			//Vector j = new Vector(5);
			//System.out.println(j);
			
			
			//test get:
			//double value = v.get(-5);
			//System.out.println("my test, this should give me something" +value  );
			
			//test set:
			//System.out.println("test set");
			//v.set(8,7); 
			//System.out.println(v);
			
			//test change dim
			//System.out.println("Test changing dimensions");
			//v.changeDim(6);
			//System.out.println(v);
			
			//test scalar add in place
			//v.scalarMultInPlace(2);
			//System.out.println("test scalar multiplication, should modify v: " + v);
			
			//testing change dim 
			//System.out.println("testing change dim");
			//v.changeDim(10);
			//System.out.println(v);
			
			//testing elementwise add in place 
			//Vector j = new Vector("[ 2 3 4 5 ]");
			//System.out.println("testing elementwise add in place");
			//v.elementwiseAddInPlace(j);
			//System.out.println(v);
			
			//testing elementwise add, v isn't modified, new vector created 
			//Vector j = new Vector("[ 2 3 4 5 6 ]");
			//System.out.println("testing elementwise add");
			//Vector f = v.elementwiseAdd(j);
			//System.out.println("v should be the same" + v);
			//System.out.println("new vector should be the two vectors added" + f);
			
			//testing elementwise multiply in place 
			//Vector j = new Vector("[ 2 3 4 5 6 ]");
			//System.out.println("testing elementwise multiply in place");
			//v.elementwiseMultInPlace(j);
			//System.out.println(v);
			
			//testing elementwise multiply, v isn't modified, new vector created 
			//Vector j = new Vector("[ 2 3 4 5 6 ]");
			//System.out.println("testing elementwise multiply");
			//Vector f = v.elementwiseMult(j);
			//System.out.println("v should be the same" + v);
			//System.out.println("new vector should be the two vectors multiplied" + f);
			
			//testing inner product 
			//System.out.println("Testing inner product ");
			//Vector l = new Vector("[ 1.5 2.3 3 4 6 ]");
			//Vector n = new Vector("[ 2 3 4 5 6 ]");
			//double result = Vector.InnerProd(l,n);
			//System.out.println(result);
		
			//testing making new matrix all initialized to zero 
			//System.out.print("New matrix");
			//Matrix n =new  Matrix(3,4);
			//System.out.println("test matrix" + n);
			
			//test set 
			//n.set(2, 1, 15);
			//n.set(0, 0, 4);
			//n.set(1, 2, 160);
			//System.out.print("This is n:" + n);
			
			//System.out.println("Testing get" + n.getRow(0));
			
			//testing equals for blank matrices --- STILL NEED TO TEST WITH FULL ONES DON'T SLEEP ON THIS 
			//Matrix f = new Matrix(4,4);
			//boolean isSame = n.equals(f);
			//System.out.println("Are they same?" + isSame);
			
			//testing getNumRows 
			//System.out.println("number of rows in the matrix is " + n.getNumRows() );
			
			//testing getNumCols 
			//System.out.println("number of cols in the matrix is " + n.getNumCols() );
			
			//test get for matrix ----STILL NEED TO TEST FOR FULL MATRIX DO NOT FORGET TO TEST 
			///System.out.println("the value at this place is " + n.get(-1,3));
			
			Matrix m = Matrix.GetIdentity(5);
			System.out.println("5. identity matrix m:\n" + m);
			System.out.println("6. still identity after self-multiply:\n" + Matrix.Multiply(m, m)); 
			
			m.set(2, 0, 2);
			m.set(0, 2, 3);
			m.set(4, 0, 5);
			
			System.out.print(m);
			System.out.println("the value at this place is " + m.get(0,2));

			System.out.println("7. m should be modified:\n" + m); // Remember: this automatically invokes m.toString()!
			System.out.println("8. result should not be the identity:\n" + Matrix.Multiply(m, m));
			System.out.println("9. example matrix/vector multiply: " + Matrix.Multiply(m, v));
			
			Matrix m2 = new Matrix(m);
			System.out.println("10. should be equal: " + m2.equals(m));
			m2.set(0, 1, 2d);
			System.out.println("11. should not be equal: " + m2.equals(m));
			
			Matrix m3 = new Matrix(5,4);
			m3.set(2, 1, 2.0);
			m3.set(2, 3, 3.0);
			Matrix m4 = m3.transpose();
			System.out.println("12. should be 4 X 5:\n" + m4);
			System.out.println("13. should be 5 X 5:\n" + Matrix.Multiply(m3, m4));
			System.out.println("14. should work:\n" + Matrix.Multiply(m4, v));
			//System.out.println("15. should throw Exception: " + Matrix.Multiply(m3, v));

			
			//16. test get
			System.out.println("16. Test get" + m4.get(2, 3));
		
			//17 test getRow 
			System.out.println("17. Test getRow " + m4.getRow(1));
			
			
			
			
			/**			
//TESTING VECTOR.JAVA 
			
			//16- Testing Vector constructor for v input 
			Vector v2 = new Vector(v);
			System.out.println("16. should print same vector as v" + v2);
			
			//17- Testing vector initialization 
			Vector v3 = new Vector("[ 5 4 3 2 1 0 ]");
			System.out.println("17. testing vector initialization" + v3);
			
			//18 - testing vector equals 
			Vector v4 = new Vector("[ 3 4 5 6 7 ]");
			System.out.println("18a. Should be equal" + v4.equals(v) );
			System.out.println("18b. Should not be qual" + v3.equals(v));
			
			//19 - testing get dim
			System.out.println("19. Getting dim of 6 value vector" + v3.getDim());
			
			//20 - testing get 
			System.out.println("20. test get, should be 2  " + v3.get(3));
			
			//21- test set 
			v3.set(3, 456);
			System.out.println("21. test set, setting 3rd index to 456" + v3);
			
			
			//22- test change dim
			v2.changeDim(10);
			System.out.println("v2 should now have dim = 10" + v2);
			v2.changeDim(2);
			System.out.println("v2 should now have dim=2" + v2);
			
			//scalar add and scalar add in place already testes 
			
			//23- scalar multiply in place 
			v4.scalarMultInPlace(2);
			System.out.println("23. Should multiply v4 [3 4 5 6 7 ] by 2" + v4);
			
			//24 - scalar multiply
			System.out.println("24. Should multiply previous by 2 again" + v4.scalarMult(2)); 
			System.out.println("But not change original " + v4);
			
			//25 - elementwise add in place 
			v4.elementwiseAddInPlace(v);
			System.out.println("25. testing elementwise add in place" + v4) ;
			//v4.elementwiseAddInPlace(v3);
			
			//26 testing elementwise add 
			//v4.elementwiseAddInPlace(v);
			System.out.println("26. testing elementwise add in" + v4.elementwiseAdd(v)) ;
			System.out.println("Shouldn't change" + v4) ;
			
			//27. tetsing elementwise multiply in place  
			v4.elementwiseMultInPlace(v);
			System.out.println("27. testing elementwise add in place" + v4) ;
			
			//28. testing elementwise mult not in place 
			System.out.println("28. testing elementwise add in" + v4.elementwiseMult(v)) ;
			System.out.println("Shouldn't change" + v4) ;
			
			//29. testing inner product 
			System.out.print("29. testing inner product " + Vector.InnerProd(v,v4));
		**/
		} catch (LinAlgException e) {
			System.out.println("EXCEPTION: " + e.getMessage());
			System.exit(1); // Exits the program
		}
	}

}
