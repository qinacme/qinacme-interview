def ladderLength(start, end, dict):
        # write your code here
        wordSet = set()
        for word in dict:
            wordSet.add(word)
        wordSet.add(end)
        wordSet.add(start)
        queue = [start]
        wordLen = len(start)
        level = 0
        while queue:
            print(queue)
            print(wordSet)
            level += 1
            newQueue = []
            for curr in queue:
                if curr == end:
                    return level
                wordSet.remove(curr)
                for i in range(wordLen):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        if curr[i] == c:
                            continue
                        newWord = curr[:i]+c+curr[i+1:]
                        if newWord in wordSet:
                            newQueue.append(newWord)
            queue = newQueue
        return 0

if __name__ == '__main__':
    print(ladderLength('a', 'c', ['a', 'b', 'c']))
