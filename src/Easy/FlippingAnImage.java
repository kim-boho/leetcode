package Easy;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for(int[] temp:image){
            for(int i=0; i<n/2; i++){
                if(temp[i] != temp[n-i-1]){
                    temp[i] = temp[n-i-1];
                    temp[n-i-1] = temp[i] == 0? 1:0;
                }
            }
        }
        for(int i=0; i<image.length; i++){
            for(int j=0; j<n; j++){
                image[i][j] = image[i][j] == 0? 1:0;
            }
        }
        return image;
    }
}
