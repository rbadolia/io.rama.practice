package in.rama.practise.array;

import java.util.ArrayList;
import java.util.List;

public class MinTime {
    public String solution(int A, int B, int C, int D, int E, int F) {
        // write your code in Java SE 8
        int[] arr={A,B,C,D,E,F};
        int hh=24, mm=60, ss=60;

        ArrayList<ArrayList<Integer>> permutations = permute(arr);
        for(List<Integer> a : permutations){
            int hh1 = 10*a.get(0)+a.get(1);
            int mm1 = 10*a.get(2)+a.get(3);
            int ss1 = 10*a.get(4)+a.get(5);

            if(isValid(hh1, mm1, ss1)){
                if(hh1 < hh){
                    hh = hh1;
                    mm = mm1;
                    ss = ss1;
                }
                if(hh == hh1 && mm1 < mm){
                    hh = hh1;
                    mm = mm1;
                    ss = ss1;
                }

                if(hh == hh1 && mm == mm1 && ss1 < ss){
                    hh = hh1;
                    mm = mm1;
                    ss = ss1;
                }
            }
        }

        String h, m, s;
        if (hh < 10) {
            h = "0" + hh;
        } else {
            h = String.valueOf(hh);
        }
        if (mm < 10) {
            m = "0" + mm;
        } else {
            m = String.valueOf(mm);
        }
        if (ss < 10) {
            s = "0" + ss;
        } else {
            s = String.valueOf(ss);
        }

        String result = h + ":" + m + ":" + s;
        if (result.startsWith("24") || result == "24:60:60") {
            return "NOT POSSIBLE";
        }

        return result;

    }

    private boolean isValid(int hh, int mm, int ss){
        if(hh < 24 && mm < 60 && ss < 60){
            return true;
        }
        return false;
    }

    private ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //start from an empty list
        result.add(new ArrayList<>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size()+1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<>(current);
        }

        return result;
    }
}

