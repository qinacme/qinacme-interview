# https://paper.dropbox.com/doc/Interview-Notes-LinkedIn-XpkQDo8ZICGjEmNdn4do0
# sort by 1s in binary notation
def sort_by_1s(nums):
    nums.sort(key = lambda x: sum(int(d) for d in bin(x)[2:]))
    return nums

l1 = [1,2,3,4,5,6]
print(sort_by_1s(l1))

# ascending parity permutation
def odd_even_perm(n):
    res = []
    def dfs(path, visited, is_odd):
        if len(visited) == n:
            res.append(path[:])
        for i in range(1, n+1):
            if i in visited or (i%2 == 0 and is_odd) or (i%2 == 1 and (not is_odd)):
                continue
            visited.add(i)
            path.append(i)
            dfs(path, visited, not is_odd)
            visited.remove(i)
            path.pop()
    if n % 2 == 0:
        dfs([], set(), True)
        dfs([], set(), False)
        res.sort()
    else:
        dfs([], set(), True)
        res.sort()
    return res

print(odd_even_perm(3))
print(odd_even_perm(4))

# Monsoon Umbrellas(coin change)
def getUmbrellas(n, p):
        MAX = float('inf')
        dp = [0] + [MAX for i in range(n)]
        for i in range(1, n+1):
            dp[i] = min(dp[i-u]+1 if i-u>=0 else MAX for u in p)
        return -1 if dp[n]==MAX else dp[n]

# shift strings
# http://www.1point3acres.com/bbs/thread-443861-1-1.html
def getShiftedString(s, leftShifts, rightShifts):
    n = len(s)
    shifts = (leftShifts-rightShifts)%n
    return (s[:shifts][::-1]+s[shifts:][::-1])[::-1]

print(getShiftedString('abcde', 0, 2))

def maxDifference(a):
    res = -1
    min_left = a[0]
    for n in a[1:]:
        diff = n - min_left
        res = max(res, diff)
        min_left = min(min_left, n)
    if res == 0:
        return -1
    return res

print(maxDifference([0]))





















# eof
