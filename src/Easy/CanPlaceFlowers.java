package Easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++){
            if(n > 0 && flowerbed[i] == 0){
                if((i-1>=0 && flowerbed[i-1] == 0) || i == 0){
                    if((i+1<flowerbed.length && flowerbed[i+1] == 0) || i == flowerbed.length-1){
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return n == 0;
    }
}
