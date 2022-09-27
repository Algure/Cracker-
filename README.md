# Cracker-
This algorithm resolves linear equations with 1 unknown. Cracker's ultimate function is named "crack1" and it requires 2 parameters- both strings. The first is a String of a linear equation of one unknown which must have an "=" sign and then a String of the independent variable (character). 

The whole algorithm is based on string processing. Hence, certain alphabets can't be used as variables - 'a, x,l, s, '. 

Suggested variables are 'g d m q and r'. 

Cracker's functions are all static for obvious reasons (It's Java). A sample of the test is found in cracker's main function. 

        
        String equation="2+3m=5";// this line assigns the equation
        System.out.println("\n"+equation);
        System.out.println(crack1(equation,"m"));//result computation
        
The result?
         m=+1.1063829787234043

Theoretically, any LINEAR equation consisting of the characters in the layout below  excluding "/" (division) can be evaluated by cracker.


![img_20180104_004328_174](https://user-images.githubusercontent.com/37802577/51503484-9668ba80-1ddb-11e9-86be-ceee4bd5e30e.jpg)


HAVE FUN!!!!!!!
