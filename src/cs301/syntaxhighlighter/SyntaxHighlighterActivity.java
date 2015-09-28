package cs301.syntaxhighlighter;

/**
 * This is a very simple activity that contains a multi-line text edit 
 * field for the user to type into. 
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class SyntaxHighlighterActivity extends Activity {

	/** This list might be useful for initializing your hash set */
	public static final String[] reservedWords = { "abstract", "assert",
			"boolean", "break", "byte", "case", "catch", "char", "class",
			"const", "continue", "default", "do", "double", "else", "enum",
			"extends", "false", "final", "finally", "float", "for", "goto",
			"if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "null", "package", "private", "protected",
			"public", "return", "short", "static", "strictfp", "super",
			"switch", "synchronized", "this", "throw", "throws", "transient",
			"true", "try", "void", "volatile", "while" };
	
	/** a reference to the main text field.  Init'd in onCreate */
	private EditText currentText = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.syntaxhighlighter);

		//Setup the text watcher
		currentText = (EditText) findViewById(R.id.javaCodeEditText);
		SyntaxTextWatcher watcher = new SyntaxTextWatcher();
		currentText.addTextChangedListener(watcher);
	}//onCreate

	/**
	 * These strings are used as test cases. Some tests that should be here have
	 * been deliberately omitted. Make up more of your own tests cases!
	 */
	private String tests[] = {
			"package cs301.syntax;",
			"Scanner kbd = new Scanner(System.in);",
			"/* I know that final is a reserved word */",
			"/* this short comment \n spans \n multiple lines */  while(x < 3)",
			"long longint = (long)\"return\".length(); //is not a short",
			"package cs301.syntax;\n"
					+ "\n"
					+ "/* Here are the reserved words:\n"
					+ " * abstract  assert  boolean  break  byte  case  catch char  class  const  continue  default  do  double else  enum  extends  false  final  finally  float for  goto  if  implements  import  instanceof  int interface  long  native  new  null  package  private protected  public  return  short  static  strictfp  super switch  synchronized  this  throw  throws  transient  true try  void  volatile  while\n"
					+ " */\n"
					+ "\n"
					+ "import android.widget.EditText;\n"
					+ "\n"
					+ "public class JavaSyntaxHighlighter extends Activity {\n"
					+ "\n"
					+ "    @Override\n"
					+ "    public void onCreate(Bundle savedInstanceState) {\n"
					+ "        super.onCreate(savedInstanceState);\n"
					+ "        setContentView(R.layout.syntax);\n"
					+ "        //Setup the text watcher\n"
					+ "    }//onCreate\n" 
					+ "}//class SyntaxActivity\n" };
	
	/** This method is called when a test button is pressed. It inserts some test 
	 * text into the main text pane
	 */
	public void testButtonHandler(View testButton) 
	{
		int id = testButton.getId();
		
		//This is kind of a cheap hack.  I'm relying on the test button ids being 
		//assigned sequentially to generate an index into the tests array
		int index = id - R.id.buttonTest1;
		
		this.currentText.setText(tests[index]);
	}//testButtonHandler
	

}// class SyntaxActivity
