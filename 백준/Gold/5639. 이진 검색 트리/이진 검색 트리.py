import sys

sys.setrecursionlimit(10**6)
# sys.stdin = open("input.txt")
input = sys.stdin.readline

#전위 순회 (루트-왼쪽-오른쪽) -> 후위 순회 (왼쪽-오른쪽-루트)
def inv_preOrder(start: int, end: int) -> None:
    if start > end:
        return

    root = preOrder[start]

    mid = start + 1
    while mid <= end and preOrder[mid] < root:
        mid+=1

    inv_preOrder(start+1, mid-1)
    inv_preOrder(mid, end)

    print(root)

if __name__ == "__main__":
    preOrder = []
    while True:
        try:
            tmp = int(input())
            preOrder.append(tmp)
        except:
            break
    inv_preOrder(0, len(preOrder) - 1)
