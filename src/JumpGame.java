//It has a time complexity of O(n)
public class JumpGame {
    public static boolean canJump(int[] nums){
         int n = nums.length;
        int can_reach = 0;
        for(int i = 0;i <= can_reach;i++){
            if(i == n - 1){
                return true;
            }
            can_reach = Math.max(can_reach,i + nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array1 = new int[]{2,3,1,1,4};
        int[] array2 = new int[]{3,2,1,0,4};
        System.out.println(canJump(array1));
        System.out.println(canJump(array2));
    }
}
