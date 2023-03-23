import sys

# sys.stdin = open("input.txt")
input = sys.stdin.readline

def solution():
    minf = min(f, W-f)
    # 처음 접은 부분 전체
    if x2 <= minf:
        print(W*H - 2 * (x2-x1) * (y2-y1) * (c+1))
    # 처음 접은 부분 일부 + 접히지 않은 부분 일부
    elif x1 < minf < x2:
        print(W*H - (2 * (minf-x1) * (y2-y1) * (c+1) + (x2-minf) * (y2-y1) * (c+1)))
    # 처음 접히지 않은 부분 전체
    else:
        print(W*H - (x2-x1) * (y2-y1) * (c+1))


if __name__ == "__main__":
    W, H, f, c, x1, y1, x2, y2 = map(int, input().split())
    solution()