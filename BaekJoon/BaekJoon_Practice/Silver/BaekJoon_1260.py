import sys
from collections import deque

# 재귀 깊이 제한 설정 (DFS용)
sys.setrecursionlimit(10**6)

def solve():
    # 입력 처리
    input = sys.stdin.read().split()
    if not input:
        return
    
    n = int(input[0])  # 정점의 개수
    m = int(input[1])  # 간선의 개수
    v = int(input[2])  # 탐색을 시작할 정점의 번호
    
    # 인접 리스트 생성
    adj = [[] for _ in range(n + 1)]
    cursor = 3
    for _ in range(m):
        u = int(input[cursor])
        w = int(input[cursor + 1])
        adj[u].append(w)
        adj[w].append(u)
        cursor += 2
        
    # 정점 번호가 작은 것을 먼저 방문하기 위해 정렬
    for i in range(1, n + 1):
        adj[i].sort()
        
    # DFS (깊이 우선 탐색)
    dfs_visited = [False] * (n + 1)
    dfs_result = []
    
    def dfs(curr):
        dfs_visited[curr] = True
        dfs_result.append(str(curr))
        for next_node in adj[curr]:
            if not dfs_visited[next_node]:
                dfs(next_node)
                
    dfs(v)
    print(" ".join(dfs_result))
    
    # BFS (너비 우선 탐색)
    bfs_visited = [False] * (n + 1)
    bfs_result = []
    
    def bfs(start_node):
        queue = deque([start_node])
        bfs_visited[start_node] = True
        
        while queue:
            curr = queue.popleft()
            bfs_result.append(str(curr))
            for next_node in adj[curr]:
                if not bfs_visited[next_node]:
                    bfs_visited[next_node] = True
                    queue.append(next_node)
                    
    bfs(v)
    print(" ".join(bfs_result))

if __name__ == "__main__":
    solve()
