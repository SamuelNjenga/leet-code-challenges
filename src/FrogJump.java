import java.util.HashSet;
import java.util.Stack;

public class FrogJump {
    public static boolean canCross(int[] stones){
        for(int i = 3;i < stones.length; i++){
            if(stones[i] > stones[i - 1] * 2){
                return false;
            }
        }
        HashSet<Integer> stonePositions = new HashSet<>();
        for(int stone : stones){
            stonePositions.add(stone);
        }
        int lastStone  = stones[stones.length - 1];
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps  = new Stack<>();
        positions.add(0);
        jumps.add(0);
        while(!positions.isEmpty()){
            int position = positions.pop();
            int jumpDistance = jumps.pop();
            for(int  i = jumpDistance - 1;i <= jumpDistance + 1;i++){
                if(i <= 0) continue;
                int nextPosition = position + i;
                if(nextPosition == lastStone){
                    return true;
                } else if(stonePositions.contains(nextPosition)){
                    positions.add(nextPosition);
                    jumps.add(i);
                }

            }

        }
        return false;
    }
    public static void main(String[] args) {
         int[] stones1  = new int[]{0,1,2,3,4,8,9,11};
         int[] stones2  = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones1));
        System.out.println(canCross(stones2));
    }
}
