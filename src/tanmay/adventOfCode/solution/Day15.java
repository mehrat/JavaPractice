package tanmay.adventOfCode.solution;

/**
 * Created by tanmaymehra on 12/15/16.
 */
public class Day15 {

    public static void main(String[] args) {

        int[] pos = {13, 17, 19, 7, 5, 3, 11};

        int[] ini = {10, 15, 17, 1, 0, 1,0};

        // 3 2 2 6 5 2

        int i = 0;
        int t =0;
        while (true) {
//            int k=0;
//            while((ini[k] + i+1+t) %pos[k] ==0 ){
//
//            }

            if ((ini[0] + i+1 )% pos[0]== 0 && (ini[1] + i+ 2)% pos[1]== 0 && (ini[2] + i + 3)% pos[2]== 0 && (ini[3] + i + 4)% pos[3]== 0
                    && (ini[4] + i + 5)% pos[4]== 0 && (ini[5] + i + 6)% pos[5]== 0 &&  (ini[6] + i + 7)% pos[6]== 0) {
                break;

            }else{
                i++;
            }

        }
        System.out.println(i);


//        int[] pos = {5,2};
//        int[] ini = {4,1};

//        int t = 1;
//        int i=0;
//        while(i < pos.length){
//
//            while((ini[i]+t) % pos[i] != 0){
//                t++;
//            }
//            i++;
//            if((ini[i]+t+1)%pos[i] != 0){
//                t= t+ini[i-1]+1;
//                i=0;
//            }else{
//                i++;
//            }
//        }
//        System.out.println(t - pos.length + 1);
    }

// t=2 +1 +1


}


//127909