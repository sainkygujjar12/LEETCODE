class Solution {
    public int maxProduct(int n) {
        int first = 0;
        int second = 0;

        int temp = n;
        while(temp>0){
            int digit = temp%10;

            if(digit>first){
                second = first;
                first = digit;
            }else if(second<digit){
                second = digit;
            }

            temp/=10;
        }
        return first*second;
    }
}