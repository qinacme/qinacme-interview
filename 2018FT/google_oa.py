def group_gt_1(L):
    if L == []:
        return 0
    def clean_email(email):
        at_idx = email.index('@')
        name = email[:at_idx].replace('.', '')
        if '+' in name:
            name = name[:name.index('+')]
        return name+email[at_idx:]
    my_map = {}
    for email in L:
        cleaned_email = clean_email(email)
        if cleaned_email not in my_map:
            my_map[cleaned_email] = [email]
        else:
            my_map[cleaned_email].append(email)
    cnt = 0
    for group in my_map.values():
        if len(group) > 1:
            cnt = cnt + 1
    return cnt



def pick_fruit(lst):
    if lst == []:
        return 0
    my_map = {}
    j = 0
    max_cnt = 0
    for i in range(len(lst)):
        cur_fruit = lst[i]
        if len(my_map) == 2:
            if cur_fruit in my_map:
                my_map[cur_fruit] = my_map[cur_fruit] + 1
            else:
                max_cnt = max(max_cnt, sum(my_map.values()))
                while len(my_map) == 2:
                    post_fruit = lst[j]
                    my_map[post_fruit] = my_map[post_fruit] - 1
                    if my_map[post_fruit] == 0:
                        del my_map[post_fruit]
                    j = j + 1
                my_map[cur_fruit] = 1
        else:
            if cur_fruit in my_map:
                my_map[cur_fruit] = my_map[cur_fruit] + 1
            else:
                my_map[cur_fruit] = 1
    return max(max_cnt, sum(my_map.values()))





e1 = 'a.b@example.com'
e2 = 'dupli......cate@example.com'
e3 = 'd.u.p.l.i.c.a.t.e@example.com'
e4 = 'ab+work@example.com'
L = [e1, e2, e3, e4]
print(group_gt_1(L))


l1 = []
l2 = [1]
l3 = [1,1,1,1,1]
l4 = [1,2,1,2,1,2,1]
l5 = [1,2,1,3,4,3,5,1,2]

print(pick_fruit(l1))
print(pick_fruit(l2))
print(pick_fruit(l3))
print(pick_fruit(l4))
print(pick_fruit(l5))
