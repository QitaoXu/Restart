package Interview.BB; 

public class CandyCrushII {

    public String deleteExtra(String s) {

        StringBuilder sb = new StringBuilder();

        boolean todo = false;
        int[] sa = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i); 

            sa[i] = c - 'a' + 1;
        }

        for (int i = 0; i + 2 < sa.length; i++) {

            int v = Math.abs(sa[i]);

            if (Math.abs(sa[i + 1]) == v && Math.abs(sa[i + 2]) == v) {

                sa[i] = sa[i + 1] = sa[i + 2] = -v;
                todo = true;
            }
        }

        for (int i = 0; i < sa.length; i++) {

            if (sa[i] < 0) 
                continue;

            sb.append(s.charAt(i));
        }

        return todo == true ? deleteExtra(sb.toString()) : sb.toString();
    }
}