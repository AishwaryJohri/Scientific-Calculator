package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;

public class Cal_Home extends Activity implements OnClickListener {

	TextView tv1,tv2;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bminus,bmul,bdiv,beql,bdot,bclear,bback,bopenbrk,bclosebrk;
	Button bcos,bsin,btan,bcosh,bsinh,btanh,bpow,bfact,bpi,be,binverse,bsquare,bsqrt,blog,bln;
	String result=null;
	static CharSequence  tv1str=null,tv2str=null;
	Calculator cal=new Calculator();
	Boolean flag=true,eqflag=true;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_cal__home);
        
        tv1 = (TextView)findViewById(R.id.textView1);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        
        tv2 = (TextView)findViewById(R.id.textView2);
        
        tv1.setText(tv1str);
        tv2.setText(tv2str);
        
        b1 =  (Button)findViewById(R.id.btn_one);
        b2 =  (Button)findViewById(R.id.btn_two);
        b3 =  (Button)findViewById(R.id.btn_three);
        b4 =  (Button)findViewById(R.id.btn_four);
        b5 =  (Button)findViewById(R.id.btn_five);
        b6 =  (Button)findViewById(R.id.btn_six);
        b7 =  (Button)findViewById(R.id.btn_seven);
        b8 =  (Button)findViewById(R.id.btn_eight);
        b9 =  (Button)findViewById(R.id.btn_nine);
        b0 =  (Button)findViewById(R.id.btn_zero);
        bplus = (Button)findViewById(R.id.btn_plus);
        bminus = (Button)findViewById(R.id.btn_minus);
        bmul = (Button)findViewById(R.id.btn_multiple);
        bdiv = (Button)findViewById(R.id.btn_divide);
        beql = (Button)findViewById(R.id.btn_equal);
        bclear = (Button)findViewById(R.id.btn_clear);
        bback = (Button)findViewById(R.id.btn_back);
        bdot = (Button)findViewById(R.id.btn_dot);
        bopenbrk = (Button)findViewById(R.id.btn_bracket_open);
        bclosebrk = (Button)findViewById(R.id.btn_bracket_close);
        
        
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) 
        {
	        bcos = (Button)findViewById(R.id.btn_cos);
	        bsin = (Button)findViewById(R.id.btn_sin);
	        btan = (Button)findViewById(R.id.btn_tan);
	        bcosh = (Button)findViewById(R.id.btn_cosh);
	        bsinh = (Button)findViewById(R.id.btn_sinh);
	        btanh = (Button)findViewById(R.id.btn_tanh);
	        blog = (Button)findViewById(R.id.btn_log);
	        bln = (Button)findViewById(R.id.btn_ln);
	        bfact = (Button)findViewById(R.id.btn_fact);
	        bsquare = (Button)findViewById(R.id.btn_square);
	        bsqrt = (Button)findViewById(R.id.btn_sqrt);
	        be = (Button)findViewById(R.id.btn_e);
	        binverse = (Button)findViewById(R.id.btn_inverse);
	        bpi = (Button)findViewById(R.id.btn_pi);
	        bpow = (Button)findViewById(R.id.btn_pow);
	       
	        bcos.setOnClickListener(this);
	        bsin.setOnClickListener(this);
	        btan.setOnClickListener(this);
	        bcosh.setOnClickListener(this);
	        bsinh.setOnClickListener(this);
	        btanh.setOnClickListener(this);
	        blog.setOnClickListener(this);
	        bln.setOnClickListener(this);
	        bfact.setOnClickListener(this);
	        bsquare.setOnClickListener(this);
	        bsqrt.setOnClickListener(this);
	        be.setOnClickListener(this);
	        binverse.setOnClickListener(this);
	        bpi.setOnClickListener(this);
	        bpow.setOnClickListener(this);
        
     }
        
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bplus.setOnClickListener(this);
        bminus.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        beql.setOnClickListener(this);
        bclear.setOnClickListener(this);
        bback.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bopenbrk.setOnClickListener(this);
        bclosebrk.setOnClickListener(this);
              
    }

    
    private void entryNos(String nos)
    {
    	int size,charWidth;
    	
    	if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
    	 	{
    			size = 55;
    			charWidth=12;
    	 	}
    	 else {
    		size =37;
    		charWidth=25;
    	 }
    	
    	 int i = tv1.getText().length()+nos.length();
    	 if(i<charWidth)
    		 tv1.setTextSize(size);  	 
    	 else if(i>charWidth)
    		tv1.setTextSize(size-11);
    	tv1.append(nos);
    }

    
   private void entryNosFormat(String nos)
   {
	   if(nos!=null){
	   result = nos;
	   int len = nos.length();
			if(len>11)
			{
				for(int i=len-2;i>=len-5;i--)
				{
					if(nos.charAt(i)=='E')
					{
						result = nos.substring(0,12-len+i)+nos.substring(i,len);
						break;
					}
				}
			}
			tv2.setText(result);
			return;
	   }
	   tv2.setText(null);
   }
   
 
private int checkOpr(char c)
	{
		switch (c) {
		case '+':
		case '-':
		case '/':
		case 'x':
		case '^':
			return 1;
		case '(':
			return 2;
		case ')':
			return 3;
		case '.':
			return 4;
		case 'e':
		case '\u03c0':
			return 5;
		case '!':
		    return 6;
		case '\u221a':
			return 7;
		default:
			return 0;
		}
	}
   
   
   private void checkAMD(String s)
   {
	   String str = tv1.getText().toString();
	   int len = str.length();
	   if(len!=0 )
	   {
		   char c=str.charAt(len-1);
		   int i=checkOpr(c);
		   if(i!=2){
		   if(i==1)
		   	  {
			   	tv1.setText(str.substring(0,len-1));
			   	if(len>1)
				   {
			   		int j = checkOpr(str.charAt(len-2));
			   			if(j==1 || j==2 )
			   				tv1.setText(str.substring(0,len-2));
			   }
			   	entryNos(s);
			   	return;
			  }
			   entryNos(s);
		   }
	   }
   }

   
   private void checkMinus()
   {
	   String str = tv1.getText().toString();
	   int len = str.length();
	   
	   if(len!=0)
	   {
		   char c = str.charAt(len-1);
		   
		   if(c=='+'||c=='-')
		   {
			   tv1.setText(str.substring(0,len-1));
			   	entryNos("-");
			   	return;
	      }
	   }
		   entryNos("-");
   }
   
   
   private void checkNos(String s)
   {
	   String str = tv1.getText().toString();
	   int len = str.length();
	   
	   if(len!=0 && checkOpr(s.charAt(0))==5)
	   {
		   char c = str.charAt(len-1);
		   int i = checkOpr(c);
		   if(i==3||i==5||i==0||i==6)
			   entryNos("x"+s);
		   else
			   entryNos(s);
		   return;
	   }
	   
	   if(len!=0 && (checkOpr(str.charAt(len-1))==3 || checkOpr(str.charAt(len-1))==5 || checkOpr(str.charAt(len-1))==6))
		   	entryNos("x"+s);
	   else
		   entryNos(s);
   }
	
   
   private void checkFunc(String s)
   {
	   String str = tv1.getText().toString();
	   int len = str.length();
	   
	   if(len!=0)
	   {
		   char c = str.charAt(len-1);
		   int i = checkOpr(c);
		   if(i==0||i==3||i==5||i==6){
			   entryNos("x"+s);
			   return;
		   }
	   }
		   entryNos(s);
   }
   
   
   private void checkFact(String s)
   {
	   String str = tv1.getText().toString();
	   int len = str.length();
	   if(len!=0)
	   {
		   char c = str.charAt(len-1);
		   int i = checkOpr(c);
		   if(i==0||i==3||i==5)
			   entryNos(s);
	   }
   }
   
   
   private void checkRoot(String s)
   {
	   String str = tv1.getText().toString();
	   int len = str.length();
	   
	   if(len!=0)
	   {
		   char c = str.charAt(len-1);
		   int i = checkOpr(c);
		   if(i==0||i==3||i==5||i==6)
			   entryNos("x"+s);
		   else if(i==1 ||i==2)
			   entryNos(s);
		   else if(i==7)
			   entryNos("("+s);
	   }
	   else
		   entryNos(s);
   }
   
   
   private void checkBrk() {
	   
	   String str = tv1.getText().toString();
	   int len = str.length();
	   
	   if(len!=0)
	   {
		   int i=checkOpr(str.charAt(len-1));
		   if( i==3 || i==0|| i==4)
			   {
			   	entryNos("x(");
			   		return;
			   }
		   entryNos("(");
	   }
	   else
	   entryNos("(");
}
   
   
   private void checkDot()
   {
	   String str = tv1.getText().toString();
	   int len = str.length();
	   
	   if(len!=0)
	   {
		   int i = checkOpr(str.charAt(len-1));
		   if(i==4)
			   return;
		   if(i==3)
		   {
			   entryNos("x.");
			   return;
		   }
	   }
	   entryNos(".");
   }
   
   
   private void finalResult(String nos)
   {
	   	entryNosFormat(nos);
   }
   
   
   private void tempResult(){
	   
	   cal.expression(tv1.getText()+"=");
	   
	   String str = cal.result();
	   
	if(str.equals("ERROR"))
	   finalResult(null);
	else
		finalResult(str);
	  
   }
   
   
	@Override
	public void onClick(View v) {
		
		if(flag){
		
		switch (v.getId()) {
		case R.id.btn_one:
			checkNos("1");
			break;
			
		case R.id.btn_two:
			checkNos("2");
			break;
			
		case R.id.btn_three:
			checkNos("3");
			break;
			
		case R.id.btn_four:
			checkNos("4");
			break;
			
		case R.id.btn_five:
			checkNos("5");
			break;
			
		case R.id.btn_six:
			checkNos("6");
			break;
			
		case R.id.btn_seven:
			checkNos("7");
			break;
			
		case R.id.btn_eight:
			checkNos("8");
			break;
			
		case R.id.btn_nine:
			checkNos("9");
			break;
			
		case R.id.btn_zero:
			checkNos("0");
			break;
		
		case R.id.btn_pi:
			checkNos("\u03c0");
			break;
			
		case R.id.btn_e:
			checkNos("e");
			break;
			
		case R.id.btn_cos:
			checkFunc("cos(");
			break;
			
		case R.id.btn_sin:
			checkFunc("sin(");
			break;
			
		case R.id.btn_tan:
			checkFunc("tan(");
			break;
			
		case R.id.btn_cosh:
			checkFunc("cosh(");
			break;
			
		case R.id.btn_sinh:
			checkFunc("sinh(");
			break;
			
		case R.id.btn_tanh:
			checkFunc("tanh(");
			break;

		case R.id.btn_log:
			checkFunc("log(");
			break;
			
		case R.id.btn_ln:
			checkFunc("ln(");
			break;
			
		case R.id.btn_inverse:
		{	
			String str = tv1.getText().toString();
			int len = str.length();
			if(len!=0){
				int i = checkOpr(str.charAt(len-1));
				if(i==0)
				{
					entryNos("x1/");
					break;
				}
			}
			checkNos("1/");
			break;
		}
			
		case R.id.btn_square:
			checkAMD("^2");
			break;
			
		case R.id.btn_plus:
			checkAMD("+");
			break;
			
		case R.id.btn_minus:
			checkMinus();
			break;
			
		case R.id.btn_multiple:
			checkAMD("x");
			break;
			
		case R.id.btn_divide:
			checkAMD("/");
			break;
			
		case R.id.btn_pow:
			checkAMD("^");
			break;
			
		case R.id.btn_fact:
			checkFact("!");
			break;
			
		case R.id.btn_sqrt:
			checkRoot("\u221a");
			break;
			
		case R.id.btn_dot:
			checkDot();
			break;
			
		case R.id.btn_bracket_close:
			entryNos(")");
			break;
			
		case R.id.btn_bracket_open:
			checkBrk();
			break;
			
		case R.id.btn_clear:
			tv1.setText(null);
			tv2.setText(null);
			tv1str = null;
			tv2str = null;
			break;
			
		case R.id.btn_back:
			CharSequence cs	=  tv1.getText();
			int len = cs.length();
			if(len>1)
			{
				tv1.setText(null);
				if(len>2)
				{	
					char c = cs.charAt(len-2);
					
					if(cs.charAt(len-1)=='(')
						{
							if(c=='n' && cs.charAt(len-3)=='l')
							{
								entryNos(cs.subSequence(0,len-3).toString());
								return;
							}
							if(len>3){
								if(c=='s'||c=='g'||c=='n')
								{
									entryNos(cs.subSequence(0,len-4).toString());
									return;
								}
								if(c=='h' && len>4)
								{
									entryNos(cs.subSequence(0, len-5).toString());
									return;
								}
							}
						}
				}
					entryNos(cs.subSequence(0, cs.length()-1).toString());
			}
			else
				tv1.setText(null);
			break;
			
		case R.id.btn_equal:
			tv2.setText(null);
			eqflag=false;
		    cal.expression(tv1.getText()+"=");
		    String str = cal.result();
		    if(str!=null){
		    	if(str.equals("ERROR")){
		    		tv1.setTextColor(Color.RED);
		    		flag=false;
		    	}
		    		tv1.setText(str);
		    }
			break;	
		default:
			break;
		}
		
		if(eqflag)
			tempResult();
		eqflag=true;
		
}	
else if(v.getId()==R.id.btn_clear)
		{
			flag=true;
			tv1.setTextColor(Color.rgb(69, 69, 69));
			tv1.setText(null);
			tv2.setText(null);
			tv1str = null;
			tv2str = null;
		}
		tv1str = tv1.getText();
		tv2str = tv2.getText();
	}
}


//*****************************************************************************************************************************************************
//*****************************************************************************************************************************************************
//************************************ CALCULATOR WORKING LOGIC ***************************************************************************************
//*****************************************************************************************************************************************************
//*****************************************************************************************************************************************************




class Calculator
{
	private Stack<String> st = new Stack<String>() ;
	private Stack<String> data = new Stack<String>();
	private DecimalFormat df = new DecimalFormat("#.000000");
	private Exception excp = new Exception();
	
	String exp;
	
	public Calculator() {
		this.exp=null;
	}
	
	
	public Calculator(String exp) {
		this.exp=exp;
	}
	
	
	public void expression(String exp)
	{
		this.exp= exp;
	}
	
	
	private double conv(String str)
	{
		if(str.equals("."))
			str="0";
		return Double.parseDouble(str);
	}
	
	
	
// NEGATIVE NUMBER CHECK
	private boolean negCheck(char c)
	{
		switch (c) {
		case '+':
		case 'x':
		case '/':
		case '^':
		case '(':
			return true;
		default:
			return false;
		}
	}
	
	
	
//FACTORIAL
	private  double factorial(int n) {
		if(n<=170 && n>=-170){
		if(n==1 || n==0)
			return 1;
		else if(n<0) 
			return (n)*factorial((-n)-1);
		else
			return n*factorial(n-1);
		}
		return (double)n/(double)0.00;
} 
	
	
// 	PRIORITY MANAGER	
	
private int priority(String s)
{
	if(s.equals("-")||s.equals("+"))
		return 1;
	if(s.equals("x")||s.equals("/"))
		return 2;
	if(s.equals("cos")||s.equals("sin")||s.equals("tan")||s.equals("cosh")||s.equals("sinh")||s.equals("tanh")||s.equals("log")||s.equals("ln"))
		return 5;
	if(s.equals("^"))
		return 3;
	if(s.equals("!"))
		return 4;
	if(s.equals("\u221a"))
		return 5;
	return 0;
}


//EVALUATION LOGIC

private void evaluate(String s) throws Exception
{
	if(s.equals(")"))
	{
		if(st.empty() && data.empty())
			throw excp;
		if(!data.empty() && st.empty())
			return;
		String str = st.pop();
		while(!str.equals("("))
		 {
			evaluate(str);
			if(st.empty())
				break;
			 str=st.pop();
		 }
		return;
	}
	if(s.equals("/"))
	{
		double temp1=conv(data.pop()),temp2=conv(data.pop());
		data.push(temp2/temp1+"");
		return;
	}
	if(s.equals("x"))
	{
		double temp1=conv(data.pop()),temp2=conv(data.pop());
		data.push(temp2*temp1+"");
		return;
	}
	if(s.equals("+"))
	{
		double temp1=conv(data.pop()),temp2=conv(data.pop());
	
		data.push((temp2+temp1)+"");
		return;
	}
	if(s.equals("-"))
	{
		double temp1=conv(data.pop()),temp2=conv(data.pop());
		data.push((temp2-temp1)+"");
		return;
	}
	if(s.equals("^"))
	{
			double temp1=conv(data.pop()),temp2=conv(data.pop());
			data.push(Math.pow(temp2, temp1)+"");
			return;
	}
	if(s.equals("!"))
	{
		double temp1=conv(data.pop());
		data.push(factorial((int)temp1)+"");
		return;
	}
	if(s.equals("cos"))
	{
		double temp1 = conv(data.pop());
		data.push(conv(df.format(Math.cos(temp1)+1))-1+"");
		return;
	}
	if(s.equals("sin"))
	{
		double temp1 = conv(data.pop());
		data.push(conv(df.format(Math.sin(temp1)+1))-1+"");
		return;
	}
	if(s.equals("tan"))
	{
		double temp1 = conv(data.pop());
		data.push(conv(df.format(Math.tan(temp1)+1))-1+"");
		return;
	}
	if(s.equals("sinh"))
	{
		double temp1 = conv(data.pop());
		data.push(Math.sinh(temp1)+"");
		return;
	}
	if(s.equals("cosh"))
	{
		double temp1 = conv(data.pop());
		data.push(Math.cosh(temp1)+"");
		return;
	}
	if(s.equals("tanh"))
	{
		double temp1 = conv(data.pop());
		data.push(Math.tanh(temp1)+"");
		return;
	}
	if(s.equals("log"))
	{
		double temp1 = conv(data.pop());
		data.push(Math.log10(temp1)+"");
		return;
	}
	if(s.equals("ln"))
	{
		double temp1 = conv(data.pop());
		data.push(Math.log(temp1)+"");
		return;
	}
	if(s.equals("\u221a"))
	{
		double temp1 = conv(data.pop());
		data.push(Math.sqrt(temp1)+"");
		return;
	}
}
	
//OPERATOR STACK MANAGER AND BODMAS MANAGER
	
	private void oprStack(String c,int p) throws Exception
	{
		
		if(st.empty()){
			st.push(c);
			return;
		}
		
		if(c.equals(")"))
			{
				evaluate(c);
				return;
			}
		
		while(!st.empty())
		{
			String str = st.pop();
			int prio = priority(str);
		
			if(str.equals("(") || p>prio)
			{
				st.push(str);
				if(c.equals("!"))
					{
							evaluate(c);return;
					}
				break;
			}
			if(p<=prio)
			{
				evaluate(str);
				if(p==4)
				{
					evaluate(c);return;
				}
			}
		}
		st.push(c);
		
	}
	

	
//EXPRESSION FETCHING 	
	
	 private void fetch() throws Exception
	 {
		 
		String temp="";
		
		int length = exp.length();
		
		int i=0;
		
		while(i<length)
		{
			char c = exp.charAt(i);
			
			switch(c){
			case '-':{
				
				if(i==0 || negCheck(exp.charAt(i-1)))
					temp="-";
				else {
					if(!temp.equals(""))
						data.push(temp);
					oprStack("-",1);
					temp="";
				}
					break;
			}
			case '+':{
				if(!temp.equals(""))
					data.push(temp);
				oprStack("+",1);
				temp="";
				break;
			}
			case 'x':{
				if(!temp.equals(""))
					data.push(temp);
				oprStack("x",2);
				temp="";
				break;
			}
			case '/':{
				if(!temp.equals(""))
					data.push(temp);
				oprStack("/",2);
				temp="";
				break;
			}
			case '^':{
				if(!temp.equals(""))
					data.push(temp);
				oprStack("^",3);
				temp="";
				break;
			}
			case '(':{
				st.push("(");
				temp="";
				break;
			}
			case ')':{
				if(!temp.equals(""))
					data.push(temp);
				oprStack(")",0);
				temp="";
				break;
			}
			case '!':{
				if(!temp.equals(""))
					data.push(temp);
				oprStack("!",4);
				temp="";
				break;
			}
			case '\u221a':
				if(!temp.equals(""))
					data.push(temp);
				oprStack("\u221a",5);
				temp="";
				break;
			case '=':
				{
					if(!temp.equals(""))
					data.push(temp);
					break;
				}
			default:
				{
					temp=temp+c;
					if(temp.equals("cos") || temp.equals("sin") || temp.equals("tan") || temp.equals("log") || temp.equals("ln") || temp.equals("sinh") || temp.equals("cosh") || temp.equals("tanh"))
					{
						st.push(temp);
						temp="";
						break;
					}
					if(temp.equals('\u03c0'+""))
					{
						data.push("3.141592656");
						temp="";
						break;
					}
					if(temp.equals("e"))
					{
						data.push(Math.E+"");
						temp="";
						break;
					}
					
				}
			}
			i++;
		}
	 }
	 

	 
// FUNC TO START MANIPULATION AND PROVIDE FINAL RESULT	 
	 
public String result()
	 {
		data.removeAllElements();
		st.removeAllElements();
		 try{
			 	if(exp!=null){
						fetch();
						if(!data.empty()){
								while(!st.empty()){									
									evaluate(st.pop());
								}
						String str = data.pop();
						if(str.equals("."))
							return "0.0";
						return str;
						}
			 	}
		 }
		 catch(Exception e){
			 return "ERROR";
		 }
		 return "";
	 }
}