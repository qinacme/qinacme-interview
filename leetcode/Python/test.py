class Node():
    def __init__(self, val):
        self.val = val
        self.next = None

    def __str__(self):
        s = str(self.val)
        temp = self
        while temp.next != None:
            s += (' -> ' + str(temp.next.val))
            temp = temp.next
        return s

def delete(linkList, val):
    if linkList == None:
        return linkList
    temp = Node(0)
    temp.next = linkList
    tempHead = temp
    while temp.next != None:
        while temp.next.val == val:
            cur = temp.next
            temp.next = cur.next
            del cur
        temp = temp.next
    result = tempHead.next
    del tempHead
    return result


if __name__ == '__main__':
    a = Node(1)
    temp = a
    for i in [2,5,5,6,2]:
        temp.next = Node(i)
        temp = temp.next
    print(a)
    print(delete(a, 5))
