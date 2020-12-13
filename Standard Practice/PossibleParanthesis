import java.util.*;
public class GFG{
private int count=0;
private int length=0;
private Map<String,List<Boolean>> hMap = new HashMap<String,List<Boolean>>();

private List<Boolean> calSum(String word){
    System.out.println(word);
    List<Boolean> res = new LinkedList<Boolean>() ; 
    if(hMap.containsKey(word)) return hMap.get(word);
    if(word.length()>1)
    for( int i =0;i<word.length();i++){
    if(word.substring(i,i+1).equals("^") || 
    word.substring(i,i+1).equals("&") || 
    word.substring(i,i+1).equals("|")){
            
    List<Boolean> left = calSum(word.substring(0,i));
    List<Boolean> right = calSum(word.substring(i+1));
    String op = (word.substring(i,i+1));
    boolean result =false;
    for( int m=0;m<left.size();m++){
        boolean l = left.get(m);
        for( int n=0;n<right.size();n++){
        boolean r = right.get(n);
        if(op.equals("^")){
        result = l ^ r;
        }else  if(op.equals("|")){
        result = l || r;
        }else if (op.equals("&")){
        result = l && r;
        }
        }
        
    res.add(result);
    if(word.length()==length && result ==true){
    count = count +1;
     }
    }
    }
    
    }
    
    if(res.size()==0){
    if(word.equals("T")) res.add(true);
    else if (word.equals("F")) res.add(false);
    }else{
          hMap.put(word,res);  
    }
    

    return res;

}

public void getMaxLength(char[] input ,char[] symbol){
    StringBuilder word= new StringBuilder();
    int count=0;
     for( int i =0;i<input.length;i++){
        if(count <symbol.length){
         word.append(input[i]).append(symbol[count]);   
         count = count+1;
        } else{
         word.append(input[i]);
        }
    }
    this.length = word.toString().trim().length();
    
    calSum(word.toString().trim());
    System.out.println(count);
}

public static void main(String arg[]){
    char[] input ={ 'T','T','F', 'T'};
    char[] symbol ={'|','&','^'};
    
    GFG sol = new GFG();
    sol.getMaxLength(input,symbol);

}
}
