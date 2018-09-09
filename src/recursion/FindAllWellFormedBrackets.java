package recursion;

public class FindAllWellFormedBrackets {
    public static void main(String[] args){
        int n =3;
        printAllWellFormedBrackets(n,n,"");
    }
    public static void printAllWellFormedBrackets(int l,int r,String s){
        if(r<=0){
            System.out.println(s);
            return;
        }
        if(l>0){
            printAllWellFormedBrackets(l-1,r,s+"(");
            if(r>l){
                printAllWellFormedBrackets(l,r-1,s+")");
            }
        }
        else if(r>0){
            printAllWellFormedBrackets(l,r-1,s+")");
        }

    }
}
