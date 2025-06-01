import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        MaximalRectangle mr=new MaximalRectangle();
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(mr.maximalRectangle(matrix));
    }
    public int maximalRectangle(char[][] matrix) {
        int[][] pre = calculatePref(matrix);
        int maxrect=-1;
        for(int i=0;i<pre.length;i++){
            maxrect=Math.max(maxrect,retMaxRect(pre[i]));
        }
        return maxrect;
    }
    public int retMaxRect(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxheight=-1;
        for (int i = 0; i < heights.length; i++) {
            // pehle se badi height store karte raho.
            if (stack.isEmpty() || heights[stack.peek()]<=heights[i]) {
                stack.push(i);
                continue;
            }
            // jaha pehle se chhoti height mile waha ruko.
            if (heights[stack.peek()] > heights[i]) {
                // jab tak apne se badi height milti rahe tab abhi se leke pehle jaha chhoti height mili thi waha tak ek ek karke height calculate karo .
                // sabse pehle pichle waale single bar ka.
                // then agar usse pehle koi baar hai to pichle waale bar aur usse pichle waale bar ka saath mei milake calculate karo .
                // kyuki usse chhota hi raha hoga tabhi pop nahi karaya.
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int currheight=heights[stack.pop()];
                    int pse=(!stack.isEmpty())?stack.peek():-1;
                    int nse=i;
                    maxheight=Math.max(maxheight,(currheight*(nse-pse-1)));
                }
                stack.push(i);
            }
        }
        // last mei jab array khatam ho jaaye tab next smaller element hoga array ke last ke baad kyuki waha koi baar hai nahi.
        while(!stack.isEmpty()){
            int currheight=heights[stack.pop()];
            int nse=heights.length;
            int pse=(!stack.isEmpty())?stack.peek():-1;
            maxheight=Math.max(maxheight,(currheight*(nse-pse-1)));
        }
        return maxheight;
    }

    public int[][] calculatePref(char[][] matrix){
        int[][] pref=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0){
                    pref[i][j]=matrix[i][j]-'0';
                    continue;
                }
                if(pref[i-1][j]!=0 && matrix[i][j]!='0'){
                    int prefix=pref[i-1][j]+1;
                    pref[i][j]= prefix;
                }else if(matrix[i][j]=='0'){
                    pref[i][j]=0;
                }
                else if(pref[i-1][j]==0 && matrix[i][j]!='0'){
                    pref[i][j]=1;
                }

            }
        }
        return pref;
    }
}
