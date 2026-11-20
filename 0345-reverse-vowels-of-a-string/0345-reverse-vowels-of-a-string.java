class Solution {
    public boolean isVowel(char ch){
        if(ch =='A'|| ch == 'E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }else return false;
    }
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length()-1;
        char[] arr = s.toCharArray();

        while(start<end){
            while(start<end && !isVowel(arr[start])){
                start++;
            }

            while(start<end && !isVowel(arr[end])){
                end--;
            }

            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

         return new String(arr);
    }
}