// https://paper.dropbox.com/doc/Interview-Notes-LinkedIn-XpkQDo8ZICGjEmNdn4do0
import java.util.*;

/**
 * Created by fengjiang on 9/19/18.
 */
public class Linkedin {
    public static void main(String[] args) {
        Linkedin solution = new Linkedin();
//        int[] nums = new int[]{1, 2, 6, 4};
//        int res1 = Linkedin.subarraySum(nums);
//        int res2 = Linkedin.maximumDifference(nums);
//
//        List<List<Integer>> res5 = solution.parityPermutation(6);
//        for (List<Integer> res : res5) {
//            for (Integer num : res) {
//                System.out.print(num);
//            }
//            System.out.println();
//        }
//
//        int[] A = new int[] {3, 2, 5, 67, 8, 2,123, 44,55,6 , 3};
//        int[] B = new int[] {44, 22, 66};
//        int[] res6 = solution.simpleQueries(A, B);
//        for (Integer num : res6) {
//            System.out.print(num+", ");
//        }
        int[] A = new int[] {1, 2, 3};
        Arrays.sort(A);
        solution.sortBySetBitCount(A);
        for (int num:A)
            System.out.println(num);

    }

    public static int subarraySum(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i] * (i + 1) * (len - i);
        }
        return sum;
    }


    public static int maximumDifference(int[] nums) {
        if (nums.length <= 1)
            return -1;
        int leftMin = nums[0];
        int maxDiff = -1;
        for (int i = 1; i < nums.length; i++) {
            int curDiff = nums[i] - leftMin;
            maxDiff = Math.max(maxDiff, curDiff);
            leftMin = Math.min(leftMin, nums[i]);
        }
        return maxDiff;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] mem = new int[amount + 1];
        for (int change = 1; change <= amount; change++) {
            mem[change] = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] > change)
                    break;
                if (mem[change - coins[i]] < Integer.MAX_VALUE)
                    mem[change] = Math.min(mem[change], mem[change - coins[i]] + 1);
            }
        }
        return mem[amount] < Integer.MAX_VALUE ? mem[amount] : -1;
    }

    public List<List<Integer>> parityPermutation(int n) {
        List<List<Integer>> allRes = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++)
            nums.add(i + 1);
        parityPermutationDFS(0, nums, allRes);
        Collections.sort(allRes, new LexicographicComparator());
        return allRes;
    }

    class LexicographicComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> a, List<Integer> b) {
            int diff = 0;
            for (int i = 0; i < a.size(); i++) {
                diff += (a.get(i) - b.get(i)) * Math.pow(10, a.size() - i);
            }
            return diff;
        }
    }

    public static void parityPermutationDFS(int index, ArrayList<Integer> nums, List<List<Integer>> allRes) {
        if (index == nums.size()) {
            allRes.add(new ArrayList<>(nums));
        }
        for (int i = index; i < nums.size(); i++) {
            if (index >= 1 && nums.get(index - 1) % 2 == nums.get(i) % 2)
                continue;
            Collections.swap(nums, index, i);
            parityPermutationDFS(index + 1, nums, allRes);
            Collections.swap(nums, index, i);
        }
    }

    public void rotateString(int[] nums, int k) {
        if (k > nums.length) {
            rotateString(nums, k % nums.length);
            return;
        }
        int sencondPart = nums.length - k;
        for (int i = 0, j = sencondPart - 1; i < j; i++, j--)
            swap(nums, i, j);
        for (int i = sencondPart, j = nums.length - 1; i < j; i++, j--)
            swap(nums, i, j);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--)
            swap(nums, i, j);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] simpleQueries(int[] A, int[] B) {
        Arrays.sort(A);
        Integer[] indices = new Integer[B.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return B[i1] - B[i2];
            }
        });
        int[] res = new int[B.length];
        int iA = 0;
        for (int iB = 0; iB < B.length; iB++) {
            while (iA < A.length && A[iA] <= B[indices[iB]])
                iA += 1;
            res[indices[iB]] = iA;
        }
        return res;

    }


    private class Element implements Comparable<Element> {
        String word;
        int count;

        Element(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Element another) {
            if (this.count != another.count)
                return this.count - another.count;
            else
                return -this.word.compareTo(another.word);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Deque<String> result = new LinkedList<String>();
        if (words == null || k == 0)
            return (List<String>) result;
        Map<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer curCount = counter.get(words[i]);
            if (curCount == null)
                curCount = 0;
            counter.put(words[i], ++curCount);
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        for (String word : counter.keySet()) {
            Element curEle = new Element(word, counter.get(word));
            if (minHeap.size() < k)
                minHeap.offer(curEle);
            else {
                Element minEle = minHeap.peek();
                if (curEle.compareTo(minEle) > 0) {
                    minHeap.poll();
                    minHeap.offer(curEle);
                }
            }
        }
        while (minHeap.size() != 0) {
            Element temp = minHeap.poll();
            result.addFirst(temp.word);
        }
        return (List<String>) result;
    }


    public int skipOneMaximumSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0] > 0 ? nums[0] : 0;
        int[] leftMaxSum = new int[nums.length];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            leftMaxSum[i] = curSum;
        }
        curSum = 0;
        int[] rightMaxSum = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            rightMaxSum[i] = curSum;
        }
        int res = Math.max(leftMaxSum[nums.length - 1], rightMaxSum[0]);
        for (int i = 1; i < nums.length - 1; i++) {
            int curMax = 0;
            if (leftMaxSum[i - 1] > 0)
                curMax += leftMaxSum[i - 1];
            if (rightMaxSum[i + 1] > 0)
                curMax += rightMaxSum[i + 1];
            if (nums[i] > 0)
                curMax += nums[i];
            res = Math.max(res, curMax);
        }
        return res;

    }


    public int minSum(int arr[]) {
        Arrays.sort(arr);
        int sum = arr[0], prev = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] <= prev) {
                sum += prev;
                prev += 1;
            } else {
                sum += arr[i];
                prev = arr[i];
            }
        }

        return sum;
    }


    int countBits(int a) {
        int count = 0;
        while (a != 0) {
            if ((a & 1) != 0)
                count += 1;
            a >>= 1;
        }
        return count;
    }

    void sortBySetBitCount(int arr[]) {
        List<List<Integer>> count = new ArrayList<>();
        for (int i = 0; i < 32; i++)
            count.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            int bitcount = countBits(arr[i]);
            count.get(bitcount).add(arr[i]);
        }

        int k = 0;
        for (int i = 31; i >= 0; i--) {
            List<Integer> collapsed = count.get(i);
            for (int j = 0; j < collapsed.size(); j++)
                arr[k++] = collapsed.get(j);
        }
    }


    List<Integer> cutTheStick(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int head = 0;
        int sticksLeft = nums.length;
        while (head < nums.length) {
            int tail = head;
            while (tail < nums.length && nums[tail] == nums[head])
                tail++;
            res.add(sticksLeft);
            sticksLeft -= tail - head;
            head = tail;
        }
        return res;
    }

    List<List<Integer>> groupIDs(int[] nums) {
        List<List<Integer>> mapper = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)
            mapper.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int numEle = nums[i];
            mapper.get(numEle).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int groupSize = 0; groupSize <= nums.length; groupSize++) {
            if (mapper.get(groupSize).isEmpty())
                continue;
            int index = 0;
            while (index < mapper.get(groupSize).size()) {
                List<Integer> group = new ArrayList<>();
                for (int i = 0; i < groupSize; i++)
                    group.add(mapper.get(groupSize).get(index++));
                res.add(group);
            }
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        return res;
    }

    String maxSubstring(String ori) {
        char[] str = ori.toCharArray();
        char maxChar = str[0];
        int maxCharIndex = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] > maxChar) {
                maxChar = str[i];
                maxCharIndex = i;
            }
        }
        StringBuilder res = new StringBuilder();
        char maxChar2 = str[str.length - 1];
        for (int i = str.length - 1; i >= maxCharIndex; i--) {
            if (str[i] >= maxChar2) {
                res.append(str[i]);
                maxChar2 = str[i];
            }
        }
        res.reverse();
        return res.toString();
    }

    public int findCircleNum(int[][] M) {
        int[] parents = new int [M.length];
        for(int i = 0; i < parents.length; i++)
            parents[i] = i;
        int count = M.length;
        for(int i = 0; i < M.length; i++) {
            for(int j = i+1; j < M.length; j++) {
                if(M[i][j] == 1) {
                    int i_p = find(i, parents);
                    int j_p = find(j, parents);
                    if(i_p != j_p) {
                        count--;
                        union(i_p, j_p, parents);
                    }
                }
            }

        }
        return count;
    }
    public int find(int i, int[] parents) {
        while(i != parents[i]){
            i = parents[i];
        }
        return i;
    }
    public void union(int i, int j, int[] parents) {
        if(i > j){
            int temp = i;
            i = j;
            j = temp;
        }
        parents[j] = i;

    }

}
