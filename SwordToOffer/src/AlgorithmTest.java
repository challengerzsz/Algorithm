
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}




public class AlgorithmTest {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //双栈实现队列
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    //二维数组查找
    public boolean Find(int target, int[][] array) {
        boolean result = false;

        for (int i = 0; i < array.length; i++) {
            for (int o = 0; o < array[0].length; o++) {
                if (array[i][o] == target) result = true;
            }
        }


        return result;
    }

    //字符串替换
    public String replaceSpace(StringBuffer str) {
        String strR = String.valueOf(str);
        String newStr = strR.replace(" ", "%20");

        return newStr;
    }

    //链表倒置
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }

        return arrayList;
    }


    //数组旋转最小值
    public int minNumberInRotateArray(int[] array) {
        if (array.length != 0) {
            Arrays.sort(array);
            return array[0];
        }
        return 0;
    }

    //输出第n项斐波那契
    public int Fibonacci(int n) {
        int pre1 = 1, pre2 = 1;
        int result = 1;
        if (n == 0) result = 0;
        if (n >= 3) result = pre1 + pre2;

        for (int i = 4; i <= n; i++) {
            pre1 = pre2;
            pre2 = result;
            result += pre1;
        }
        return result;
    }

    public int Fibonacci2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }


    //跳台阶
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        else if (target == 2) return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //变态跳台阶
    public int JumpFloorII(int target) {
//        int result = 0;
//        for (int i = 1; i <= target; i++) {
//            for (int j = 1; j <= target - 1; j++) {
//                if (i + j == target) result++;
//            }
//        }
//        return result;
        if (target == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= target; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target];
    }

    //快速排序
    public void QuickSort(int a[], int start, int end) {
        int tmp, i, j, base;
        base = a[start];
        i = start;
        j = end;
        if (i >= j) return;
        while (i < j) {
            while (a[j] >= base && i < j) {
                j--;
            }
            while (a[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[start] = a[i];
        a[i] = base;

        QuickSort(a, start, i - 1);
        QuickSort(a, i + 1, end);
    }

    //冒泡排序
    public void BubSort(int a[]) {
        int t;
        boolean b = true;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    b = false;
                }
            }
            if (b) {
                break;
            }
        }
    }

//    public int[] sort(int [] a, int low, int high) {
//        int mid = (low + high) / 2;
//        if (low < high) {
//            sort(a, low, mid);
//            sort(a, mid + 1, high);
//            //左右归并
//            merge(a, low, mid, high);
//        }
//        return a;
//    }
//
//    public void merge(int [] a, int low, int mid, int high) {
//        int [] tmp = new int[high - low + 1];
//        int i = low;
//        int j = mid + 1;
//        int k = 0;
//
//        //把较小的数先放在新数组中
//        while (i <= mid && j <= high) {
//            if (a[i] < a[j]) {
//                tmp[k++] = a[i++];
//            } else {
//                tmp[k++] = a[j++];
//            }
//        }
//
//        //把左边剩余移入数组
//        while (i <= mid) {
//            tmp[k++] = a[i++];
//        }
//        while (j <= high) {
//            tmp[k++] = a[j++];
//        }
//
//        for (int o = 0; o < tmp.length; o++) {
//            a[o + low] = tmp[o];
//        }
//    }


    public int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, high, mid);
        }

        return a;
    }

    public void merge(int[] a, int low, int high, int mid) {
        int i = low;
        int j = mid + 1;
        int[] newA = new int[high - low + 1];
        int index = 0;

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                newA[index++] = a[i++];
            } else {
                newA[index++] = a[j++];
            }
        }

        while (i <= mid) {
            newA[index++] = a[i++];
        }

        while (j <= high) {
            newA[index++] = a[j++];
        }

        for (int o = 0; o < newA.length; o++) {
            a[o + low] = newA[o];
        }
    }

    //插入排序
    public void Isort(int[] number) {
//        int n = number.length;
//        int temp;
//        for(int i = 1; i< n; i++) {
//            for(int j = i; j>0 && number[j-1] > number[j]; j--) {
//                temp = number[j];
//                number[j] = number[j-1];
//                number[j-1] = temp;
//            }
//        }
        int temp;
        for (int i = 1; i < number.length; i++) {
            for (int j = i; j > 0 && number[j - 1] > number[j]; j--) {
                temp = number[j];
                number[j] = number[j - 1];
                number[j - 1] = temp;
            }
        }
    }

    //简单选择排序
    public void selectSort(int[] a) {
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int t = a[min];
            a[min] = a[i];
            a[i] = t;
        }
    }


    public int search(int[] a, int target) {
        int mid;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else low = mid + 1;

        }
        return 0;
    }

    private Scanner scanner = new Scanner(System.in);
    //    public void createTree(TreeNode treeNode) {
//        int node;
//        node = this.scanner.nextInt();
//
//        System.out.println(node);
//        if (node == -1) {
////            System.out.println("-1!!!!");
//            treeNode = null;
//        } else {
//            treeNode = new TreeNode(node);
//            createTree(treeNode.left);
//            createTree(treeNode.right);
//        }
//
//    }

    public void pre(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            pre(treeNode.left);
            pre(treeNode.right);
        }
    }

    int count = 0;
    public TreeNode create(int a[], TreeNode root, int i) {
        if (i < a.length) {
            if (a[i] == 0) {
                root = null;
            }
        } else {
            TreeNode lchild = new TreeNode();
            TreeNode rchild = new TreeNode();
            root.val = a[i];
            root.left = create(a, lchild, ++count);
            root.right = create(a, rchild, ++count);
        }

        return root;
    }

    public static void main(String[] args) {

        AlgorithmTest find = new AlgorithmTest();


//        int a[][] = {{1,2,8,9}, {4,7,10,3}};
//        System.out.println(find.Find(7,a));

//        StringBuffer stringBuffer = new StringBuffer("1 2 3");
//        System.out.println(find.replaceSpace(stringBuffer));

//        LinkedList<Integer> linkedList = new LinkedList<>();

//        for (int i = 1; i <= 39; i++) {
//            System.out.println(find.Fibonacci2(i));
//        }


//        System.out.println(find.JumpFloorII(3));

        //快速排序
//        int[] a = {2,5,7,8,1,3,5};
//        find.QuickSort(a, 0, a.length - 1);
//        for (int tmp : a) {
//            System.out.println(tmp);
//        }

        //冒泡排序
//        find.BubSort(a);


        //归并排序
//        System.out.println(find.search(a, 8));
//        for (int tmp : a) {
//            System.out.println(tmp);
//        }


//        TreeNode root = find.create(a, );
////        find.createTree(treeNode);
//        find.pre(treeNode);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}