def calcEquation(equations, values, queries):
        eqs = {}
        variables = set()
        for [x, y], v in zip(equations, values):
            eqs[(x, y)] = v
            eqs[(y, x)] = 1/v
            variables.add(x)
            variables.add(y)
        def dfs(x, y, visited, mul):
            if (x, y) in eqs:
                return mul*eqs[(x, y)]
            if (x, y) in visited:
                return None
            else:
                for (p, q) in eqs.keys():
                    if not (p, q) in visited and p == x:
                        visited.add((p, q))
                        r = dfs(q, y, visited, mul*eqs[(p, q)])
                        if not r is None:
                            return r
                        else:
                            visited.remove((p, q))
                            continue
        res = []
        for [x, y] in queries:
            if (not x in variables) or (not y in variables):
                res.append(-1.0)
            else:
                if x == y:
                    res.append(1.0)
                else:
                    res.append(dfs(x, y, set(), 1.0))
        return res

equations = [ ["a","b"],["b","c"] ]
values = [2.0,3.0]
queries = [ ["a","c"],["b","c"],["a","e"],["a","a"],["x","x"] ]
print(calcEquation(equations, values, queries))
