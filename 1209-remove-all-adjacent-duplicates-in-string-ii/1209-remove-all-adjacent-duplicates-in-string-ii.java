class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb=new StringBuilder();
        int[] count=new int[s.length()];
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            int lastIndex=sb.length()-1;
            if(lastIndex>0 && sb.charAt(lastIndex)==sb.charAt(lastIndex - 1)){
            count[lastIndex]=count[lastIndex -1]+1;
        }
        else{
            count[lastIndex]=1;
        }
        if(count[lastIndex]==k){
            sb.delete(sb.length()-k,sb.length());
        }
        }
        return sb.toString();
}
}
        
  