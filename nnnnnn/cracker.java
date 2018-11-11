package nnnnnn;

public class cracker extends Mycalc {
public void cracker(){}
    
    public static int bracketend(String input,int i){
    
        int k=i+1,p=k;
      
        int i1=Mycalc.bracketendex(input, i)+1,i2=Mycalc.bracketendex(input, i)+1;
        String s4="";
       if((i1<input.length()&&((input.charAt(i1)!='+'&&input.charAt(i1)!='-')
               &&input.charAt(i1)!=')'))){
           
           // i1=getfrontinTex(input, l);
            i2=getfrontbracketinTex(input,i1);
            s4=input.substring(i1,i2);
            
        }
       if(i1==i2){
        return i1;
       }else{
       return i2;
       }
    }
    public static String resolvebracket(String input,int l){
    
        String s1="",s2="",s3="",s4="",s5="",s6="",tp="";
        double i4=0;
        int i3=0,i2=0,i1=0,n=0;
        for(int i=l+1;i<input.length();i++){
        
            if (input.charAt(i)=='('){
               //recursion test
               n=s1.length()-getbracketbacklength(input,i);
                      tp=s1.substring(0,n)+resolvebracket(input,i);
                s1=tp;
                i=bracketend(input, i)-1;
                //continue;
            
           }
         else if(input.charAt(i)==')'){
             i3=i;
            break;
        }
         else{
         
             s1+=input.substring(i,i+1);//result of bracket
         }
        }
        //back coefficient of bracket
        if ((l>0)&&(((input.charAt(l-1)=='+'||input.charAt(l-1)=='-')&&(input.charAt(l-2)=='*'||input.charAt(l-2)=='/'))||
                (input.charAt(l-1)!='+'||input.charAt(l-1)!='-')))
        {s2=(getbracketbacknum(input,l));
        s3=Mycalc.simplification1(s1);
        }
        //front coefficient of bracket
       i1=Mycalc.bracketendex(input, l)+1;
        if((i1<input.length()&&((input.charAt(i1)!='+'&&input.charAt(i1)!='-')&&input.charAt(i1)!=')'))){
           
           // i1=getfrontinTex(input, l);
            i2=getfrontbracketinTex(input,i1);
            i2=getfrontbracketinTex(input,i1);
            if(i2==i1&&input.charAt(i1)!=')'){
            s4=input.substring(i1,i2+1);
            }else{
            s4=input.substring(i1,i2);
            }
            //s4=input.substring(i1,i2);
            
        }
        s5=s2+"(1)"+s4;//resultant coefficient
        int r=0,g=0;
       String temp=s1;
       int ct=0;
       temp=s5+"*"+s1;
        g+=s5.length()+1;
         while (r<s1.length()){
        
            if ((temp.charAt(g)=='+'||temp.charAt(g)=='-')&&(temp.charAt(g-1)!='*'&&temp.charAt(g-1)!='/')){
            
                ct++;
                s6=temp.substring(0,g+1)+s5+"*"+temp.substring(g+1);
               //^s1=s6;
               temp=s6;
               g+=s5.length()+1;
            }
            r++;
            g++;
        
        }
        return (temp);
        
    }
    
public static int getbracketbacklength(String input,int i){
    
        String s1="",s2="",s3="",s4="",s5="",s6="";
        double i2=0,i3=0,i4=0;
        int i1=0;
        int u=i+1;
       i1=getbackbracketinTex(input,i);
       s2=input.substring(i1,i);
       return s2.length();
    }
   
    public static String getbracketbacknum(String input,int i){
    
        String s1="",s2="",s3="",s4="",s5="",s6="";
        double i2=0,i3=0,i4=0;
        int i1=0;
        int u=i+1;
       i1=getbackbracketinTex(input,i);
       s2=input.substring(i1,i);
       return s2;
    }
    public static String coefficientresolution1(String input,String var){
    
        String s1,s2,s3="";
        String[] res=getTerms(input,(var));
        String[] resolutions=res;
        for (int i=0;i<res.length;i++){
        
           s1=res[i].replaceAll(var, "(1)");
           s2=gunnercal(s1);
           s3+=s2;
        }
        return gunnercal(s3);
    }
    public static String crack1(String input,String var){
    
        String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="",temp="";
        String constants,coeffs;
        int i1=0,i2=0,i3=0,i4=0;
        
        i1=input.indexOf("=");
        //for the left hand side of the equation
        s1=input.substring(0,i1)+"+0";
        temp=openbracket(s1);
        s1=temp;
        s2=coefficientresolution1(s1,var);
        s3=constantsresolution(s1,var);
        //for the right hand side of the equation
        s4=input.substring(i1+1)+"+0";
       temp=openbracket(s4);
       s4=temp;
        s5=coefficientresolution1(s4,var);
        s6=constantsresolution(s4,var);
        
        constants=gunnercal(s6+"-"+s3);
        coeffs=gunnercal(s2+"-"+s5);
        s7=s6+"-"+s3+"/("+s2+"-"+s5+")";
        
        return var+"="+gunnercal(constants+"/"+coeffs);
        
    }
    public static String openbracket(String input){
    
        String s1="",tp="";
        int n=0,i3=0;
        for(int i=0;i<input.length();i++){
        
            if (input.charAt(i)=='('){
               //recursion test
               n=s1.length()-getbracketbacklength(input,i);
                      tp=s1.substring(0,n)+resolvebracket(input,i);
                s1=tp;
                i=bracketend(input, i);
                if (i!=input.length()-1){
                    i-=1;
                }
                continue;
            
            }else{
         
             s1+=input.substring(i,i+1);//result of bracket
         }
        }
        return simplification1(s1);
    }
    //transtrig functionality left
    public static void main(String[] args){
        String equation="2+3m=5+m";// this line assigns the equation
        
        System.out.println("\n"+equation);
        System.out.println(crack1(equation,"m"));//result computation
        
       
    }
    public  static boolean coperators(char i){
        boolean b=(i=='o'||i=='x'||i=='!'||i=='/'||i=='*'||i=='S'||i=='C'||i=='T'||i=='s'||i=='c'||i=='t'||i=='n'||i=='a'||i=='l'||i=='e'||i=='('||i==')'||i=='^');
        return b;
    }
    //thif function needs work
    public static String[] coeficientformat(String[] input,String variable){
    
        String[] patterns=new String[input.length];
        String temp="";
        String pattern = null;
        int y=0;
        String varsub;
        for (int h=0;h<input.length;h++){
        
            temp=input[h];
            while(y<temp.length()){
            
                if(temp.charAt(y)=='*'||temp.charAt(y)=='/'||temp.substring(y, y).matches(variable)){
                
                    pattern+=temp.substring(h,h);
                   
                }
                y++;
            }
            temp=pattern;
            pattern=temp.replaceAll(variable, "2");
            temp=gunnercal(Simpplificationcheck(pattern.replaceAll("()","(1)")));
            switch(temp){
            
                case "2":
                    pattern=variable;
                case "4":
                    pattern=variable+"^2";
                case "22":
                    pattern=variable+"^2";
                case "8":
                    pattern=variable+"^3";
                case "1":
                    pattern="constant";
                default :
                    pattern="unknown";
            }
            patterns[h]=pattern;
        }
        return patterns;
    }
    public static String constantsresolution(String input,String var){
    
        String temp="",found="",result="",temp2=input;
        int front=0,back=0,count=0;
        String[] res=getTerms(input,String.valueOf(var));
        int l=0;
        for(int i=0;i<input.length();i++){
       
           // found=input.substring(i,i+1);
             found=((i+var.length())<input.length()?input.substring(i,(i+var.length())):"");
           if ((i+var.length())<input.length()&&found.matches(var)){
       count++;
               front=getfrontinTex(input,i);
               back=getbackinTex(input,i);
               temp=input.substring(0,back)+"+"+input.substring(front);
               input=temp;
               i=0;
           }
           l=i-1;
        }
        if(input.endsWith(var)){
       
            front=getfrontinTex(input,l);
               back=getbackinTex(input,l);
           temp=input.substring(0,back);
               input=temp;
       }
        return gunnercal(input);
    }
    public static String Simpplificationcheck(String input){
    
        String temp="";
        temp=input.replaceAll("\\*\\*\\*", "\\*");
        input=temp.replaceAll("\\*\\*\\/", "\\/");
        temp=input.replaceAll("\\*\\/\\*", "\\/");
        input=temp.replaceAll("\\/\\*\\*", "\\/");
        temp=input.replaceAll("\\*\\*","\\*");
        input=temp.replaceAll("\\/\\*","\\/");
        temp=input.replaceAll("\\*\\/", "\\/");
        if (temp.startsWith("\\/")||temp.startsWith("\\*")){
        input="1"+temp;
        }else{
        input=temp;
        }
        temp=(input.endsWith("\\/")||input.endsWith("\\*")?input.substring(0,input.length()-1):input);
        return temp;
    }
    public static String[] coefficientlisting(String[] input,String variable){
    
        String[] resolutions=new String[input.length];
        String temp="";
        String resolution;
        for (int t=0;t<input.length;t++){
        
            temp=input[t].replaceAll(variable, "(1)");
            resolution=gunnercal(temp);
            resolutions[t]=resolution;
        }
        return resolutions;
    }
  //gets terms with the variable attatched to it and returns String of the terms  
   public static String[] getTerms(String input ,String var){
   String result="";
   String found="";
   input+="+0("+var+")";
       for(int i=0;i<input.length();i++){
       
           found=((i+var.length())<input.length()?input.substring(i,(i+var.length())):"");
           if ((i+var.length())<input.length()&&found.matches(var)){
           
               result+=getinTerm(input,i)+",";  
               //i=getfrontinTex(input,i);
           }
       }
       if(input.endsWith(var)){
       
           result+=getinTerm(input,input.lastIndexOf(var))+","; 
       }
      String[] res=result.substring(0,result.length()-1).split(",");
       return(res);
   }
   
   public static int getbackinTex(String input,int i){
   
       int res=0;
       for (int k=i;k>=0;k--){
       
           if ((input.charAt(k)=='+'&&!coperators(input.charAt(k-1)))||(input.charAt(k)=='-'&&!coperators(input.charAt(k-1)))){
           
              res=k;
              break;
           }
       }
       return res;
   }
   public static int getbackbracketinTex(String input,int i){
   
       int res=0;
       for (int k=i;k-1>=0;k--){
       
           if (((input.charAt(k)=='+'&&!coperators(input.charAt(k-1)))||(input.charAt(k)=='-'&&!coperators(input.charAt(k-1))))||
                   (input.charAt(k-1)=='(')){
           
              res=k;
              break;
           }
       }
       return res;
   }
   public static int getfrontbracketinTex(String input,int i){
   
       int res=i;
       for (int k=i;k<input.length();k++){
        if (((input.charAt(k)=='+'||input.charAt(k)=='-'||(input.charAt(k)==')')))){
              
            res=k;
              break;
           }
         
          res=k;
       }
       return res;
   }
   public static int getfrontinTex(String input,int i){
   
       int res=input.length();
       for (int k=i;k<input.length()-1;k++){
       
          if ((input.charAt(k)=='+'&&!coperators(input.charAt(k-1)))||(input.charAt(k)=='-'&&!coperators(input.charAt(k-1)))){
           
              res=k;
              break;
           }
       }
       return res;
   }
public static String getinTerm(String input, int i){

    int front=getfrontinTex(input,i);
    int back=getbackinTex(input,i);
    
    String result=input.substring(back,front);
    return result;
}
    
}
