package Easy;

public class DesignParkingSystem {
    int[] arr;
    public DesignParkingSystem(int big, int medium, int small) {
        arr = new int[] {big,medium,small};
    }

    public boolean addCar(int carType) {
        return arr[carType-1]-- > 0;
    }
}
