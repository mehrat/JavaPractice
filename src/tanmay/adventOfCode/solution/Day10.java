package tanmay.adventOfCode.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by tanmaymehra on 12/10/16.
 */
public class Day10 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/tanmaymehra/Documents/demo49/JavaPractice/src/tanmay/adventOfCode/solution/day10.txt");
        Scanner s = new Scanner(file);

        Map<Integer, Bot> bots = new HashMap<>();

        while (s.hasNext()) {
            String st = s.nextLine();
            if (st.substring(0, 3).equals("bot")) {

                String[] arr = st.split(" ");
                int id = Integer.parseInt(arr[1]);
                if (!bots.keySet().contains(id)) {
                    int low = -1, high = -1, olow = -1, ohigh = -1;
                    if (arr[5].equals("bot")) {
                        low = Integer.parseInt(arr[6]);
                    } else {
                        olow = Integer.parseInt(arr[6]);
                    }
                    if (arr[10].equals("bot")) {
                        high = Integer.parseInt(arr[11]);
                    } else {
                        ohigh = Integer.parseInt(arr[11]);
                    }
                    Bot bot = new Bot(id, -1, -1, low, high, olow, ohigh);
                    bots.put(id, bot);
                } else {
                    int low = -1, high = -1, olow = -1, ohigh = -1;
                    if (arr[5].equals("bot")) {
                        low = Integer.parseInt(arr[6]);
                    } else {
                        olow = Integer.parseInt(arr[6]);
                    }
                    if (arr[10].equals("bot")) {
                        high = Integer.parseInt(arr[11]);
                    } else {
                        ohigh = Integer.parseInt(arr[11]);
                    }
                    Bot b = bots.get(id);
                    b.low = low;
                    b.high = high;
                    b.olow = olow;
                    b.ohigh = ohigh;
                    bots.put(id, b);
                }
            }

            if (st.substring(0, 5).equals("value")) {
                String[] arr = st.split(" ");
                int id = Integer.parseInt(arr[5]);
                int val = Integer.parseInt(arr[1]);
                if (bots.keySet().contains(id)) {
                    Bot b = bots.get(id);
                    if (b.v1 == -1) {
                        b.v1 = val;
                    } else {
                        b.v2 = val;
                    }
                } else {
                    Bot bot = new Bot(id, val, -1, -1, -1, -1, -1);
                    bots.put(id, bot);
                }
            }
        }
        int[] output = new int[21];
        for (int i = 0; i < 20; i++) {
            output[i] =-1;
        }
        while (true) {
            executeBotCommands(bots, output);
        }


//        for (Map.Entry<Integer, Bot> e : bots.entrySet()) {
//            Bot bot = e.getValue();
//            if ((bot.v1 == 61 && bot.v2 == 17) || (bot.v2 == 61 && bot.v1 == 17)) {
//                System.out.println(e.getKey());
//            }
//        }


    }

    private static void executeBotCommands(Map<Integer, Bot> bots, int[] output) {
        for (Map.Entry<Integer, Bot> e : bots.entrySet()) {
            Bot bot = e.getValue();
            if (bot.v1 != -1 && bot.v2 != -1) {
                if(bot.id == 142){
                    System.out.println();
                }
//                if ((bot.v1 == 61 && bot.v2 == 17) || (bot.v1 == 17 && bot.v2 == 61)) {
//                    System.out.println(bot.id);
//                    System.exit(0);
//                }
                if (bot.low != -1) {
                    Bot lowBot = bots.get(bot.low);
                    if (bot.v1 < bot.v2 && bot.v1 != -1) {
                        if (lowBot.v1 == -1) {
                            lowBot.v1 = bot.v1;
                        } else {
                            lowBot.v2 = bot.v1;
                        }
                        bot.v1 = -1;
                    } else if (bot.v2 != -1) {
                        if (lowBot.v1 == -1) {
                            lowBot.v1 = bot.v2;
                        } else {
                            lowBot.v2 = bot.v2;
                        }
                        bot.v2 = -1;
                    }
                    bot.low = -1;
                }
                if (bot.high != -1) {
                    Bot highBot = bots.get(bot.high);
                    if (bot.v1 > bot.v2 && bot.v1 != -1) {
                        if (highBot.v1 == -1) {
                            highBot.v1 = bot.v1;
                        } else {
                            highBot.v2 = bot.v1;
                        }
                        bot.v1 = -1;
                    } else if (bot.v2 != -1) {
                        if (highBot.v1 == -1) {
                            highBot.v1 = bot.v2;
                        } else {
                            highBot.v2 = bot.v2;
                        }
                        bot.v2 = -1;
                    }
                    bot.high = -1;
                }

                //put in output
                if (bot.olow != -1) {
                    if (bot.v2 !=-1 && bot.v1 < bot.v2 && bot.v1 != -1) {
                        output[bot.olow] = bot.v1;
                        bot.v1 = -1;
                    } else if (bot.v2 != -1) {
                        output[bot.olow] = bot.v2;
                        bot.v2 = -1;
                    }
                    bot.olow = -1;
                }
                if (bot.ohigh != -1) {
                    if (bot.v1 > bot.v2 && bot.v1 != -1) {
                        output[bot.ohigh] = bot.v1;
                        bot.v1 = -1;
                    } else if (bot.v2 != -1) {
                        output[bot.ohigh] = bot.v2;
                        bot.v2 = -1;
                    }
                    bot.ohigh = -1;
                }
            }
        }

        if (output[0] != -1 && output[1] != -1 && output[2] != -1) {
            System.out.println();
        }

    }


}

class Bot {
    int id;
    int v1, v2;
    int low;
    int high;
    int olow;
    int ohigh;

    public Bot(int id, int v1, int v2, int low, int high, int olow, int ohigh) {
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
        this.low = low;
        this.high = high;
        this.olow = olow;
        this.ohigh = ohigh;
    }
}
