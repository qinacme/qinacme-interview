def select_movie(m_lens, dur):
    dur -= 30
    len_to_idx = {l: i for i, l in enumerate(m_lens)}
    m_lens.sort()
    left, right = 0, len(len_to_idx)-1
    while left+1 < right:
        if m_lens[left] + m_lens[right] > dur:
            right -= 1
        else:
            break
    if m_lens[left] + m_lens[right] > dur:
        return []
    return [len_to_idx[m_lens[left]], len_to_idx[m_lens[right]]]

def select_movie_bf(m_lens, dur):
    dur -= 30
    n = len(m_lens)
    m_dur = 0
    long_m = 0
    short_m = 0
    res = []
    for i in range(n-1):
        for j in range(i+1, n):
            t1, t2 = m_lens[i], m_lens[j]
            if t1+t2 <= dur and t1+t2>=m_dur:
                if t1+t2 != m_dur:
                    m_dur = t1+t2
                    long_m, short_m = max(t1, t2), min(t1, t2)
                    res = [i, j]
                else:
                    if max(t1, t2) > long_m:
                        long_m, short_m = max(t1, t2), min(t1, t2)
                        res = [i, j]
    return res

l1 = [22,28,23,43,32,42,38,57]
d1 = 90
print(select_movie_bf(l1, d1))
print(select_movie(l1, d1))



def select_movie_eq(m_lens, dur):
    dur -= 30
    len_to_idx = {l: i for i, l in enumerate(m_lens)}
    m_lens.sort()
    left, right = 0, len(len_to_idx)-1
    while left+1 < right:
        if m_lens[left] + m_lens[right] > dur:
            right -= 1
        elif m_lens[left] + m_lens[right] < dur:
            left += 1
        else:
            return [len_to_idx[m_lens[left]], len_to_idx[m_lens[right]]]
    return []

def select_movie_eq_bf(m_lens, dur):
    dur -= 30
    n = len(m_lens)
    long_m = 0
    short_m = 0
    res = []
    for i in range(n-1):
        for j in range(i+1, n):
            t1, t2 = m_lens[i], m_lens[j]
            if t1+t2 == dur and max(t1, t2) > long_m:
                    long_m, short_m = max(t1, t2), min(t1, t2)
                    res = [i, j]
    return res

l1 = [22,28,23,43,32,42,38,57]
d1 = 90
print(select_movie_eq_bf(l1, d1))
print(select_movie_eq(l1, d1))



from collections import Counter
def substring_len_k(s, k):
    if k > len(s) or not s:
        return 0
    freq = Counter(s[:k])
    # res = 1 if len(freq) == k else 0
    subs = {s[:k]} if len(freq) == k else set()
    for idx in range(0, len(s)-k):
        freq[s[idx]] -= 1
        if freq[s[idx]] == 0:
            del freq[s[idx]]
        if s[idx+k] in freq:
            freq[s[idx+k]] += 1
        else:
            freq[s[idx+k]] = 1
        if len(freq) == k:
            # res += 1
            subs.add(s[idx+1:idx+k+1])
    # return res
    return len(subs)

def substring_len_k_bf(s, k):
    # res = 0
    subs = set()
    for i in range(len(s) - k + 1):
        if len(set(s[i:i+k])) == k:
            # res += 1
            subs.add(s[i:i+k])
    # return res
    return len(subs)

s = "fjadisganighasdkhguolsajdoufjhuqteoarhwsdyfibvansdf"
k = 4
print(len(s))
print(substring_len_k(s, k))
print(substring_len_k_bf(s, k))



def min_max(matrix):
    if not matrix or not matrix[0]:
        return 0
    n, m = len(matrix), len(matrix[0])
    dp = [[0 for i in range(m)] for j in range(n)]
    dp[0][0] = matrix[0][0]
    for i in range(1, n):
        dp[i][0] = min(dp[i-1][0], matrix[i][0])
    for i in range(1, m):
        dp[0][i] = min(dp[0][i-1], matrix[0][i])
    for i in range(1, n):
        for j in range(1, m):
            dp[i][j] = min(max(dp[i-1][j], dp[i][j-1]), matrix[i][j])
    return dp[n-1][m-1]

matrix = [[8,4,7],[6,5,9]]
print(min_max(matrix))


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.children = []

# Be careful with Python version
# with root val
def get_large_node(root):
    def dfs(root):
        # return [largest_node, largest_weight, current_sum, current_num]
        if not root.children:
            return [root, root.val, root.val, 1]
        infos = [dfs(child) for child in root.children]
        child_weight = sum(info[2] for info in infos)
        child_num = sum(info[3] for info in infos)
        cur_weight = (root.val + child_weight)/(child_num+1)
        # cur_weight = child_weight/child_num
        child_weights = [info[1] for info in infos]
        max_child_weight = max(child_weights)
        max_child_index = child_weights.index(max_child_weight)
        if max_child_weight > cur_weight:
            return [infos[max_child_index][0], max_child_weight, root.val+child_weight, child_num+1]
        else:
            return [root, cur_weight, root.val+child_weight, child_num+1]
    if not root:
        return root
    else:
        print(dfs(root))
        return dfs(root)[0]

def getHighestSectionalLoad(rootComponent):
    # WRITE YOUR CODE HERE
    def dfs(root):
        if not root.children:
            return [root, root.value, root.value, 1, False]
        infos = [dfs(child) for child in root.children]
        childWeight = sum(info[2] for info in infos)
        childNum = sum(info[3] for info in infos)
        curWeight = (root.value + childWeight)*1.0/(childNum+1)
        childWeights = [info[1] for info in infos if info[4]]
        if childWeights:
            maxChildWeight = max(childWeights)
            maxChildIndex = childWeights.index(maxChildWeight)
            if maxChildWeight > curWeight:
                return [infos[maxChildIndex][0], maxChildWeight,
                    root.value+childWeight, childNum+1, True]
            else:
                return [root, curWeight, root.value+childWeight,
                    childNum+1, True]
        return [root, curWeight, root.value+childWeight,
                    childNum+1, True]
    return dfs(rootComponent)[0]


n0 = TreeNode(100)
n1 = TreeNode(120)
n2 = TreeNode(80)
n3 = TreeNode(40)
n4 = TreeNode(50)
n5 = TreeNode(60)
n6 = TreeNode(50)
n7 = TreeNode(70)

n0.children = [n1, n2]
n1.children = [n3, n4, n5]
n2.children = [n6, n7]

print(get_large_node(n0).val)
